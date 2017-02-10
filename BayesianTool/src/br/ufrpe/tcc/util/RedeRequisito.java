package br.ufrpe.tcc.util;

import br.ufrpe.tcc.model.Projeto;
import javabayes.InferenceGraphs.InferenceGraph;
import javabayes.InferenceGraphs.InferenceGraphNode;

public class RedeRequisito extends RedeBayesiana{
	InferenceGraph ig = new InferenceGraph();
	InferenceGraphNode estabilidadeReq;
	InferenceGraphNode complexidadeReq;
	InferenceGraphNode riscoRequisitos;
	public RedeRequisito() {
		// Setar nos da rede Bayesiana

		estabilidadeReq = createNode(ig, "estabilidadeRequisitos", 
				new String[] {"ER Muito Baixa", "ER Baixa", "ER Media", "ER Alta", "ER Muito Alta"});
		complexidadeReq = createNode(ig, "complexidadeRequisitos", 
				new String[] {"CR Muito Baixa", "CR Baixa", "CR Media", "CR Alta", "CR Muito Alta"});



		riscoRequisitos = createNode(ig, "riscoRequisitos",new String[]{"Ocorre risco", "Nao Ocorre"} );

		ig.create_arc(estabilidadeReq, riscoRequisitos);
		ig.create_arc(complexidadeReq, riscoRequisitos);
		//Estabilidade dos requisitos
		setProbabilityValues(riscoRequisitos, "ER Muito Baixa", .5008, .4992);
		setProbabilityValues(riscoRequisitos, "ER Baixa", .6659, .3341);
		setProbabilityValues(riscoRequisitos, "ER Media", .6431, .3569);
		setProbabilityValues(riscoRequisitos, "ER Alta", .598, .402);
		setProbabilityValues(riscoRequisitos, "ER Muito Alta", .0001, .9999);
		//Complexidade dos requisitos
		setProbabilityValues(riscoRequisitos, "CR Muito Baixa", .0001, .9999);
		setProbabilityValues(riscoRequisitos, "CR Baixa", .598, .402);
		setProbabilityValues(riscoRequisitos, "CR Media", .4997, .5003);
		setProbabilityValues(riscoRequisitos, "CR Alta", .8, .2);
		setProbabilityValues(riscoRequisitos, "CR Muito Alta", .9999, .0001);

		setProbabilityValues(estabilidadeReq, new double[]{.121, .273, .424, .152, .03});
		setProbabilityValues(complexidadeReq, new double[]{.03, .152, .485, .303, .03});


	}

	public double avaliarRequisitos(Projeto projeto){
		getEstabilidadeReq().set_observation_value(projeto.getEstabilidadeRequisitos());
		getComplexidadeReq().set_observation_value(projeto.getComplexidadeRequisitos());
		double beliefRequisito = getBelief(getIg(), getRiscoRequisitos());
		return perCentValue(beliefRequisito);
	}
	public InferenceGraph getIg() {
		return ig;
	}
	public void setIg(InferenceGraph ig) {
		this.ig = ig;
	}
	public InferenceGraphNode getEstabilidadeReq() {
		return estabilidadeReq;
	}
	public void setEstabilidadeReq(InferenceGraphNode estabilidadeReq) {
		this.estabilidadeReq = estabilidadeReq;
	}
	public InferenceGraphNode getComplexidadeReq() {
		return complexidadeReq;
	}
	public void setComplexidadeReq(InferenceGraphNode complexidadeReq) {
		this.complexidadeReq = complexidadeReq;
	}
	public InferenceGraphNode getRiscoRequisitos() {
		return riscoRequisitos;
	}
	public void setRiscoRequisitos(InferenceGraphNode riscoRequisitos) {
		this.riscoRequisitos = riscoRequisitos;
	}


}

