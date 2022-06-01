public enum Opcoes {
    Nao(0),
    Sim(1);

    private int inteiro;

    Opcoes(int inteiro) {
        this.inteiro = inteiro;
    }

    public int getValue() {
        return inteiro;
    }

}
