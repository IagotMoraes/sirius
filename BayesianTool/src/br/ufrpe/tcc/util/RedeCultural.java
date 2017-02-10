package br.ufrpe.tcc.util;

import br.ufrpe.tcc.model.Projeto;
import javabayes.InferenceGraphs.InferenceGraph;
import javabayes.InferenceGraphs.InferenceGraphNode;

public class RedeCultural extends RedeBayesiana{
	InferenceGraph ig = new InferenceGraph();
	InferenceGraphNode distribuicaoGeografica;
	InferenceGraphNode nivelConflito;
	InferenceGraphNode riscoCultural;
	public RedeCultural() {
		// Setar nos da rede Bayesiana
		
		distribuicaoGeografica = createNode(ig, "distribuicaoGeografica", 
				new String[]{"Mesma sala", "Mesmo predio", "Mesma cidade", "Estado diferentes", "Países diferentes"});
		nivelConflito = createNode(ig, "nivelConflito", 
				new String[] {"Muito Baixa", "Baixa", "Media", "Alta", "Muito Alta"});
		riscoCultural = createNode(ig, "riscoCultural",new String[]{"Ocorre risco", "Nao Ocorre"} );
		
		ig.create_arc(distribuicaoGeografica, riscoCultural);
		ig.create_arc(nivelConflito, riscoCultural);
		
		setProbabilityValues(riscoCultural, "Mesma sala", .1332, .8668);
		setProbabilityValues(riscoCultural, "Mesmo predio", .2505, .7495);
		setProbabilityValues(riscoCultural, "Mesma cidade", .0001, .9999);
		setProbabilityValues(riscoCultural, "Estado diferentes", .7498, .2502);
		setProbabilityValues(riscoCultural, "Países diferentes", .0001, .9999);
				
		setProbabilityValues(riscoCultural, "Muito Baixa", .1665, .8335);
		setProbabilityValues(riscoCultural, "Baixa", .3072, .6928);
		setProbabilityValues(riscoCultural, "Media", .1252, .8778);
		setProbabilityValues(riscoCultural, "Alta", .0001, .9999);
		setProbabilityValues(riscoCultural, "Muito Alta", .999, .001);

		setProbabilityValues(distribuicaoGeografica, new double[]{.455, .242, .182, .121, .01});
		setProbabilityValues(nivelConflito, new double[]{.182, .394, .242, .152, .03});
				
	}
	

		public double avaliarcultural(Projeto projeto){
			getDistribuicaoGeografica().set_observation_value(projeto.getDistribuicaoGeografica());
			getNivelConflito().set_observation_value(projeto.getNivelConflito());
			double beliefCultural = getBelief(getIg(), getRiscoCultural());
			return perCentValue(beliefCultural);
		}

		public InferenceGraphNode getDistribuicaoGeografica() {
			return distribuicaoGeografica;
		}
		public void setDistribuicaoGeografica(InferenceGraphNode distribuicaoGeografica) {
			this.distribuicaoGeografica = distribuicaoGeografica;
		}

		public InferenceGraphNode getNivelConflito() {
			return nivelConflito;
		}
		public void setNivelConflito(InferenceGraphNode nivelConflito) {
			this.nivelConflito = nivelConflito;
		}
		public InferenceGraphNode getRiscoCultural() {
			return riscoCultural;
		}
		public void setRiscoCultural(InferenceGraphNode riscoCultural) {
			this.riscoCultural = riscoCultural;
		}
		public InferenceGraph getIg() {
			return ig;
		}
		public void setIg(InferenceGraph ig) {
			this.ig = ig;
		}
}

