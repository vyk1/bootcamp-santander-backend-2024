package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Web Developer");
        bootcamp.setDescricao("Descrição Bootcamp Web Developer");

        Bootcamp bootcamp2 = new Bootcamp();
        bootcamp2.setNome("Bootcamp Java Developer");
        bootcamp2.setDescricao("Descrição Bootcamp Java Developer");

        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        bootcamp2.getConteudos().add(curso1);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        devCamila.imprimirInformacoes();
        devCamila.progredir();
        devCamila.progredir();
        System.out.println("-");
        devCamila.imprimirInformacoes();

        System.out.println("-------");

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        devJoao.imprimirInformacoes();
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("-");
        devJoao.imprimirInformacoes();

        System.out.println("-------");
        Dev devCleiton = new Dev();
        devCleiton.setNome("Cleiton");
        devCleiton.inscreverBootcamp(bootcamp);
        devCleiton.imprimirInformacoes();
        System.out.println("-");
        devCleiton.progredir();
        bootcamp.banir(devCleiton);
        System.out.println("-");
        devCleiton.progredir();

    }

}
