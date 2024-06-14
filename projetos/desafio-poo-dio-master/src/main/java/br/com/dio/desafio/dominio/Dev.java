package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        if (bootcamp.verificarSeDevEstaBanido(this)) {
            System.err.println("Você já concluiu o bootcamp " + bootcamp.getNome());
        } else {
            this.conteudosInscritos.addAll(bootcamp.getConteudos());
            bootcamp.getDevsInscritos().add(this);
        }
    }

    public void progredir(Bootcamp bootcamp) {
        if (bootcamp.verificarSeDevEstaBanido(this)) {
            System.err.println("Você foi banido do bootcamp " + bootcamp.getNome());
        } else {
            // Achar o próximo conteúdo do bootcamp
            Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
            if (conteudo.isPresent()) {
                this.conteudosConcluidos.add(conteudo.get());
                this.conteudosInscritos.remove(conteudo.get());
            } else {
                System.err.println("Você já concluiu todos os conteúdos do bootcamp " + bootcamp.getNome());
            }
        }
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public void imprimirInformacoes() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Conteúdos inscritos: ");
        for (Conteudo conteudo : conteudosInscritos) {
            System.out.println(conteudo);
        }
        System.out.println("Conteúdos concluídos: ");
        for (Conteudo conteudo : conteudosConcluidos) {
            System.out.println(conteudo);
        }
        System.out.println("XP total: " + this.calcularTotalXp());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos)
                && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
