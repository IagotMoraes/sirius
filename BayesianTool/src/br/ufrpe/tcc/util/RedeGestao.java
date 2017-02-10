package br.ufrpe.tcc.util;

import javabayes.InferenceGraphs.InferenceGraph;
import javabayes.InferenceGraphs.InferenceGraphNode;
import br.ufrpe.tcc.model.Projeto;


public class RedeGestao extends RedeBayesiana{

	InferenceGraph ig = new InferenceGraph();
	InferenceGraphNode tamanhoProj;
	InferenceGraphNode complexidadeProj;
	InferenceGraphNode riscoGestao;
	public RedeGestao() {
		// Setar nos da rede Bayesiana

		//Categoria - sistema de desenvolvimento
		tamanhoProj = createNode(ig, "TamanhoProjeto", new String[] {"Ate 50 mil", "entre 50 mil e 150 mil","entre 150 mil e 1 milhao", "entre 1 milhão e 3 milhões", "mais de 3 milhões"});
		complexidadeProj = createNode(ig, "ComplexidadeProjeto", new String[]{"Muito Baixa", "Baixa", "Media","Alta", "Muito Alta"});		
		riscoGestao = createNode(ig, "RiscoGestao",new String[]{"Ocorre risco","Não Ocorre"} );


		ig.create_arc(tamanhoProj, riscoGestao);
		ig.create_arc(complexidadeProj, riscoGestao);


		// probabilidade  caracteristicas do projeto


		//relacao para o sistema de desenvolvimento
		//Tamanho do projeto
		setProbabilityValues(riscoGestao, "Ate 50 mil", .4985, .5015);
		setProbabilityValues(riscoGestao, "entre 50 mil e 150 mil", .4985, .5015);
		setProbabilityValues(riscoGestao, "entre 150 mil e 1 milhao", .3641, .6359); //n pega
		setProbabilityValues(riscoGestao, "entre 1 milhão e 3 milhões", .3749, .6251); // n pega
		setProbabilityValues(riscoGestao, "mais de 3 milhões", .4935, .5065); //n pega
		//Complexidade do projeto
		setProbabilityValues(riscoGestao,"Muito Baixa", .0001, .9999);
		setProbabilityValues(riscoGestao,"Baixa", .501, .499);
		setProbabilityValues(riscoGestao,"Media", .312, .688); 
		setProbabilityValues(riscoGestao,"Alta", .6366, .3634); 
		setProbabilityValues(riscoGestao,"Muito Alta", .0001, .9999);


		setProbabilityValues(tamanhoProj, new double[] {.182, .182, .333, .242, .061});
		setProbabilityValues(complexidadeProj, new double[]{.01, .121, .485, .333, .061});

	}



	public double avaliarGestao(Projeto projeto){
		getTamanhoProj().set_observation_value(projeto.getTamanhoProj());
		getComplexidadeProj().set_observation_value(projeto.getComplexidadeProj());
		double beliefGestao = getBelief(getIg(), getRiscoGestao());
		return perCentValue(beliefGestao);

	}
	public InferenceGraphNode getTamanhoProj() {
		return tamanhoProj;
	}
	public void setTamanhoProj(InferenceGraphNode tamanhoProj) {
		this.tamanhoProj = tamanhoProj;
	}
	public InferenceGraphNode getComplexidadeProj() {
		return complexidadeProj;
	}
	public void setComplexidadeProj(InferenceGraphNode complexidadeProj) {
		this.complexidadeProj = complexidadeProj;
	}

	public InferenceGraphNode getRiscoGestao() {
		return riscoGestao;
	}
	public void setRiscoGestao(InferenceGraphNode riscoGestao) {
		this.riscoGestao = riscoGestao;
	}
	public InferenceGraph getIg() {
		return ig;
	}
	public void setIg(InferenceGraph ig) {
		this.ig = ig;
	}


}
