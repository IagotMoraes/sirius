package br.ufrpe.tcc.util;

import java.util.Vector;

import javabayes.InferenceGraphs.InferenceGraph;
import javabayes.InferenceGraphs.InferenceGraphNode;
import javabayes.QuasiBayesianInferences.QBInference;

public class RedeAdequacao {
	InferenceGraph ig = new InferenceGraph();
	InferenceGraphNode nivelReuso;
	InferenceGraphNode nivelInterface;
	InferenceGraphNode design;
	InferenceGraphNode riscoAdequacao;
	public RedeAdequacao() {
		// Setar nós da rede Bayesiana
		
		//Categoria - Design
		nivelReuso = createNode(ig, "NivelReuso", 
				new String[] {"Muito Baixa", "Baixa", "Média", "Alta", "Muito Alta"});
		nivelInterface = createNode(ig, "NivelInterface", 
				new String[] {"Muito Baixa", "Baixa", "Média", "Alta", "Muito Alta"});
		design = createNode(ig, "Design", new String[]{"Ocorre risco", "não Ocorre"});
		
		
		riscoAdequacao = createNode(ig, "RiscoAplicacao",new String[]{"Ocorre risco", "Nao Ocorre"} );
		
		
		ig.create_arc(nivelReuso, design);
		ig.create_arc(nivelInterface, design);
		ig.create_arc(design, riscoAdequacao);		
		
		// probabilidade  caracteristicas do projeto
		setProbabilityValues(nivelReuso, new double[]{.04, .24, .48, .2, .04});
		setProbabilityValues(nivelInterface, new double[]{.01, .2, .32, .28, .2});


		setProbabilityValues(design, "nivelReuso","Muito Baixa", .0001, .9999);
		setProbabilityValues(design, "nivelReuso","Baixa", .3333, .6667);
		setProbabilityValues(design, "nivelReuso","Média", .4167, .5833);
		setProbabilityValues(design, "nivelReuso","Alta", .2, .8);
		setProbabilityValues(design, "nivelReuso","Muito Alta", .0001, .9999);

		setProbabilityValues(design, "nivelInterface","Muito Baixa", .0001, .9999);
		setProbabilityValues(design, "nivelInterface","Baixa", .4, .6);
		setProbabilityValues(design, "nivelInterface","Média", .25, .75);
		setProbabilityValues(design, "nivelInterface","Alta", .4285, .5715);
		setProbabilityValues(design, "nivelInterface","Muito Alta", .2, .8);


		setProbabilityValues(riscoAdequacao, "design", "Ocorre risco", .5001, .4999);
		setProbabilityValues(riscoAdequacao, "design", "Nao Ocorre", .4999, .5001);
				
				

				
	}
	private static InferenceGraphNode createNode(
		    InferenceGraph ig, String name, String[] variables) {
		  ig.create_node(0, 0);
		  InferenceGraphNode node = (InferenceGraphNode) ig.get_nodes().lastElement();
		 
		  node.set_name(name);
		  ig.change_values(node, variables);
		 
		  return node;
		}
	
	private static void setProbabilityValues(InferenceGraphNode node, double[] values) {
		  node.set_function_values(values);
		}
	// resto dos trecos
	@SuppressWarnings("unchecked")
	private static int getVariableIndex(InferenceGraphNode node,String parentName, String parentVariable) {
		 
		  for (InferenceGraphNode parent : (Vector<InferenceGraphNode>) node.get_parents()) {
		    int variableIndex = 0;
		    
		    if(parent.toString().equals(parentName)){
			    for (String variable : parent.get_values()) {
			      if (variable.equals(parentVariable)) {
			        return variableIndex;
			      }
			 
			      variableIndex++;
			    }
		    }
		  }
		 
		  return 0;
		}
		 
		/**
		 * Returns the total number of values for the parent that has the given variable
		 */
		@SuppressWarnings("unchecked")
		private static int getTotalValues(InferenceGraphNode node, String parenteName, String parentVariable) {
		  for (InferenceGraphNode parent : (Vector<InferenceGraphNode>) node.get_parents()) {
			  if(parent.toString().equals(parenteName)){
				 for (String variable : parent.get_values()) {
				    if (variable.equals(parentVariable)) {
				       return parent.get_number_values();
				      }
				  }
			  }
		  }
		 
		  return 0;
		}
		 
		/**
		 * Sets probabilities for a node that has a parent
		 */
		private static void setProbabilityValues(InferenceGraphNode node, String parentName, String parentVariable, 
		    double trueValue, double falseValue) {
		  int variableIndex = getVariableIndex(node,parentName, parentVariable);
		  int totalValues = getTotalValues(node,parentName, parentVariable);
		 
		  double[] probabilities = node.get_function_values();
		  probabilities[variableIndex] = trueValue;
		  probabilities[variableIndex + totalValues] = falseValue;
		  node.set_function_values(probabilities);
		}
		 
		/**
		 * Sets probabilities for a node that has two parents
		 */
//		@SuppressWarnings("unused")
//		private static void setProbabilityValues(InferenceGraphNode node,String parentName, String firstParentVariable, 
//		    String secondParentVariable, double trueValue, double falseValue) {
//		 
//		  int variableIndex = (getVariableIndex(node, firstParentVariable) * 2) + 
//		      getVariableIndex(node, secondParentVariable);
//		  int totalValues = getTotalValues(node, firstParentVariable) + 
//		      getTotalValues(node, secondParentVariable);
//		 
//		  double[] probabilities = node.get_function_values();
//		  probabilities[variableIndex] = trueValue;
//		  probabilities[variableIndex + totalValues] = falseValue;
//		  node.set_function_values(probabilities);
//		}
		 
		/**
		 * Gets the belief/true result from the inference of the given node
		 */
		//@SuppressWarnings("unused")
		protected double getBelief(InferenceGraph ig, InferenceGraphNode node) {
		  QBInference qbi = new QBInference(ig.get_bayes_net(), false);
		  qbi.inference(node.get_name());
		  return qbi.get_result().get_value(0);
		}
		
//		public static void main(String[] args) {
//			RedeAdequacao gestao = new RedeAdequacao();
//			double belief1 = gestao.getBelief(gestao.getIg(),gestao.getDesign());
//			System.out.println("Risco Gestao: "+belief1);
//			
//		}
		
		public InferenceGraph getIg() {
			return ig;
		}
		public void setIg(InferenceGraph ig) {
			this.ig = ig;
		}
		public InferenceGraphNode getNivelReuso() {
			return nivelReuso;
		}
		public void setNivelReuso(InferenceGraphNode nivelReuso) {
			this.nivelReuso = nivelReuso;
		}
		public InferenceGraphNode getNivelInterface() {
			return nivelInterface;
		}
		public void setNivelInterface(InferenceGraphNode nivelInterface) {
			this.nivelInterface = nivelInterface;
		}
		public InferenceGraphNode getDesign() {
			return design;
		}
		public void setDesign(InferenceGraphNode design) {
			this.design = design;
		}
		public InferenceGraphNode getRiscoAdequacao() {
			return riscoAdequacao;
		}
		public void setRiscoAdequacao(InferenceGraphNode riscoAdequacao) {
			this.riscoAdequacao = riscoAdequacao;
		}
		
		
}

