public enum Opcoes {
    Nao(1),
    Sim(0);

    private int inteiro;

    Opcoes(int inteiro) {
        this.inteiro = inteiro;
    }

    public int getValue() {
        return inteiro;
    }

}
