public enum Jogada {

    PEDRA,
    PAPEL,
    TESOURA;

    public Resultado compara(Jogada adversario) {


        // Lógica de empate
        if(this == adversario){ //Se a jogada do jogador que chamou essa função (this) for igual à jogada randomizada que ele passou por parâmetro (do adversário), dará empate.
            return Resultado.EMPATE;
        }

        // Lógica de outras jogadas
        switch(this){
            case PEDRA: //Se o jogador que chamou o metodo compara (this) jogar pedrass
                return (adversario == TESOURA) ? Resultado.VITORIA  : Resultado.DERROTA;
                                                                                                // Ira retornar a seguinte lógica de comparação: se a jogada do adversario for TESOURA,
                                                                                                // o Resultado para this será VITORIA, caso contrario, será DERROTA,
                                                                                                // pois a jogada vai ser papel e a lógica de empate já foi implementada antes.
            case PAPEL:
                return (adversario == PEDRA) ? Resultado.VITORIA  : Resultado.DERROTA;


            case TESOURA:
                return (adversario == PAPEL) ? Resultado.VITORIA : Resultado.DERROTA;


            default:
                return Resultado.EMPATE; //Só por segurança vamos retornar empate, mesmo já verificando isso antes.

        }


    }

}
