package projetos.iPhone;

public interface NavegadorInternet {
    String abaAtual = "0";
    String[] abas = new String[0];

    void exibirPagina(String url);

    void adicionarNovaAba();

    void atualizarPagina();

    void fecharPaginaAtual();

    void fecharTodasAsAbas();
}