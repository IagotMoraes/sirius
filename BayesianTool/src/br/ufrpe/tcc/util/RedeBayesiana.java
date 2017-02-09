package br.ufrpe.tcc.util;

import java.util.Vector;
import javabayes.InferenceGraphs.InferenceGraph;
import javabayes.InferenceGraphs.InferenceGraphNode;
import javabayes.QuasiBayesianInferences.QBInference;

public class RedeBayesiana {
	
	
	protected static InferenceGraphNode createNode(
		    InferenceGraph ig, String name, String[] variables) {
		  ig.create_node(0, 0);
		  InferenceGraphNode node = (InferenceGraphNode) ig.get_nodes().lastElement();
		 
		  node.set_name(name);
		  ig.change_values(node, variables);
		 
		  return node;
		}
	
	protected static void setProbabilityValues(InferenceGraphNode node, double[] values) {
		  node.set_function_values(values);
		}
	
	@SuppressWarnings("unchecked")
	private static int getVariableIndex(InferenceGraphNode node, String parentVariable) {
		 
		  for (InferenceGraphNode parent : (Vector<InferenceGraphNode>) node.get_parents()) {
		    int variableIndex = 0;
		 
		    for (String variable : parent.get_values()) {
		      if (variable.equals(parentVariable)) {
		        return variableIndex;
		      }
		 
		      variableIndex++;
		    }
		  }
		 
		  return 0;
		}
		 
		/**
		 * Returns the total number of values for the parent that has the given variable
		 */
		@SuppressWarnings("unchecked")
		private static int getTotalValues(InferenceGraphNode node, String parentVariable) {
		  for (InferenceGraphNode parent : (Vector<InferenceGraphNode>) node.get_parents()) {
		 
		    for (String variable : parent.get_values()) {
		      if (variable.equals(parentVariable)) {
		        return parent.get_number_values();
		      }
		    }
		  }
		 
		  return 0;
		}
		 
		/**
		 * Sets probabilities for a node that has a parent
		 */
		@SuppressWarnings("unused")
		protected
		static void setProbabilityValues(InferenceGraphNode node, String parentVariable, 
		    double trueValue, double falseValue) {
		  int variableIndex = getVariableIndex(node, parentVariable);
		  int totalValues = getTotalValues(node, parentVariable);
		 
		  double[] probabilities = node.get_function_values();
		  probabilities[variableIndex] = trueValue;
		  probabilities[variableIndex + totalValues] = falseValue;
		  node.set_function_values(probabilities);
		}
	
		protected double getBelief(InferenceGraph ig, InferenceGraphNode node) {
		  QBInference qbi = new QBInference(ig.get_bayes_net(), false);
		  qbi.inference(node.get_name());
		  return qbi.get_result().get_value(0);
		}
		
		protected double perCentValue(double valor){
			double value = valor*100;
			String stringValue = String.format("%.4f", value);
			String[] split = stringValue.split("[,]");
			String percent = split[0]+"."+split[1];
			return Double.parseDouble(percent);
			
		}
}