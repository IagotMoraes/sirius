package br.ufrpe.tcc.util;

import br.ufrpe.tcc.model.Projeto;
import javabayes.InferenceGraphs.InferenceGraph;
import javabayes.InferenceGraphs.InferenceGraphNode;

public class RedeAplicacao extends RedeBayesiana{
	InferenceGraph ig = new InferenceGraph();
	InferenceGraphNode nivelReuso;
	InferenceGraphNode nivelInterface;
	InferenceGraphNode riscoAplicacao;
	
	public RedeAplicacao() {
		// Setar nós da rede Bayesiana
		
		//Categoria - Design
		nivelReuso = createNode(ig, "NivelReuso", 
				new String[] {"NR Muito Baixa", "NR Baixa", "NR Média", "NR Alta", "NR Muito Alta"});
		nivelInterface = createNode(ig, "NivelInterface", 
				new String[] {"NI Muito Baixa", "NI Baixa", "NI Média", "NI Alta", "NI Muito Alta"});		
		riscoAplicacao = createNode(ig, "RiscoAplicacao",
				new String[]{"Ocorre risco", "Nao Ocorre"} );
		
		
		ig.create_arc(nivelReuso, riscoAplicacao);
		ig.create_arc(nivelInterface, riscoAplicacao);
		
		
		// probabilidade  caracteristicas do projeto
		setProbabilityValues(nivelReuso, new double[]{.03, .273, .394, .273, .03});
		setProbabilityValues(nivelInterface, new double[]{.01, .182, .364, .303, .152});


		setProbabilityValues(riscoAplicacao, "NR Muito Baixa", .0001, .9999);
		setProbabilityValues(riscoAplicacao, "NR Baixa", .5549, .4451);
		setProbabilityValues(riscoAplicacao, "NR Média", .4614, .5386);
		setProbabilityValues(riscoAplicacao, "NR Alta", .5549, .4451);
		setProbabilityValues(riscoAplicacao, "NR Muito Alta", .0001, .9999);

		setProbabilityValues(riscoAplicacao, "NI Muito Baixa", .0001, .9999);
		setProbabilityValues(riscoAplicacao, "NI Baixa", .4994, .5006);
		setProbabilityValues(riscoAplicacao, "NI Média", .4994, .5006);
		setProbabilityValues(riscoAplicacao, "NI Alta", .5, .5);
		setProbabilityValues(riscoAplicacao, "NI Muito Alta", .3986, .6014);
	}
		public double avaliaraplicacao(Projeto projeto){
			getNivelReuso().set_observation_value(projeto.getNivelReuso());
			getNivelInterface().set_observation_value(projeto.getNivelInterface());
			double beliefAplicacao = getBelief(getIg(), getRiscoAplicacao());
			return perCentValue(beliefAplicacao);
		}
		
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
		public InferenceGraphNode getRiscoAplicacao() {
			return riscoAplicacao;
		}
		public void setRiscoAplicacao(InferenceGraphNode riscoAplicacao) {
			this.riscoAplicacao = riscoAplicacao;
		}
		
		
}

