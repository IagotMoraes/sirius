package br.ufrpe.tcc.util;

import br.ufrpe.tcc.model.Projeto;
import javabayes.InferenceGraphs.InferenceGraph;
import javabayes.InferenceGraphs.InferenceGraphNode;

public class RedeEconomico extends RedeBayesiana{
	InferenceGraph ig = new InferenceGraph();
	InferenceGraphNode disponibilidadeRecursos;
	InferenceGraphNode dependenciaExterna;
	InferenceGraphNode riscoEconomico;
	public RedeEconomico() {
		// Setar nós da rede Bayesiana
		
		//Categoria - Recursos
		disponibilidadeRecursos = createNode(ig, "DisponibilidadeRecursos", 
				new String[] {"DR Muito Baixa", "DR Baixa", "DR Média", "DR Alta", "DR Muito Alta"});
		//Categoria - Contratual
		dependenciaExterna = createNode(ig, "DependenciaExterna",
				new String[] {"DE Muito Baixa","DE Baixa", "DE Média", "DE Alta", "DE Muito Alta"});
		riscoEconomico = createNode(ig, "RiscoEconomico",new String[]{"Ocorre risco", "Nao Ocorre"} );
		
		ig.create_arc(disponibilidadeRecursos, riscoEconomico);
		ig.create_arc(dependenciaExterna, riscoEconomico);

		//disponibilidade de recursos
		setProbabilityValues(riscoEconomico, "DR Muito Baixa", .999, .001);
		setProbabilityValues(riscoEconomico, "DR Baixa", .0001, .9999);
		setProbabilityValues(riscoEconomico, "DR Média", .5377, .4623);
		setProbabilityValues(riscoEconomico, "DR Alta", .6655, .3345);
		setProbabilityValues(riscoEconomico, "DR Muito Alta", .999, .001);

		//Contratual
		//dependencia externa
		setProbabilityValues(riscoEconomico, "DE Muito Baixa", .4997, .5003);
		setProbabilityValues(riscoEconomico, "DE Baixa", .5377, .4623);
		setProbabilityValues(riscoEconomico, "DE Média", .9995, .0005);
		setProbabilityValues(riscoEconomico, "DE Alta", .5984, .4016);
		setProbabilityValues(riscoEconomico, "DE Muito Alta", .5001, .4999);

		setProbabilityValues(disponibilidadeRecursos, new double[]{.03, .091, .394, .455, .03});
		setProbabilityValues(dependenciaExterna, new double[]{.303, .394, .091, .152, .061});
							
		}
		public double avaliarEconomico(Projeto projeto){
			getDisponibilidadeRecursos().set_observation_value(projeto.getDisponibilidadeRecursos());
			getDependenciaExterna().set_observation_value(projeto.getDependenciaExterna());
			double beliefEconomico = getBelief(getIg(), getRiscoEconomico());
			return perCentValue(beliefEconomico);
		}
		public InferenceGraph getIg() {
			return ig;
		}
		public void setIg(InferenceGraph ig) {
			this.ig = ig;
		}
		public InferenceGraphNode getDisponibilidadeRecursos() {
			return disponibilidadeRecursos;
		}
		public void setDisponibilidadeRecursos(InferenceGraphNode disponibilidadeRecursos) {
			this.disponibilidadeRecursos = disponibilidadeRecursos;
		}
		public InferenceGraphNode getDependenciaExterna() {
			return dependenciaExterna;
		}
		public void setDependenciaExterna(InferenceGraphNode dependenciaExterna) {
			this.dependenciaExterna = dependenciaExterna;
		}
		public InferenceGraphNode getRiscoEconomico() {
			return riscoEconomico;
		}
		public void setRiscoEconomico(InferenceGraphNode riscoEconomico) {
			this.riscoEconomico = riscoEconomico;
		}
		
		

}

