package arenaobj;

import java.util.ArrayList;
import java.util.Scanner;

import model.Guerreiro;
import model.Ladrao;
import model.Pessoa;
import servicos.GuerreiroServicos;
import servicos.ServicosFactory;
import servicos.VitimaServicos;
import view.Principal;

public class ArenaObj {
    static Scanner ler = new Scanner(System.in);
    static int opMP;
    static ArrayList<Guerreiro> guerreiros = new ArrayList<>();
    static ArrayList<Ladrao> ladroes = new ArrayList<>();
    static ArrayList<Pessoa> vitimas = new ArrayList<>();

    private static int opSM;

    public static int lerInt() {
        Scanner leia = new Scanner(System.in);
        int num = 99;
        try {
            num = leia.nextInt();
        } catch (Exception e) {
            System.out.print("Tente novamente: ");
            lerInt();
        }
        return num;
    }

    public static void main(String[] args) {
      //  System.out.println("-- Arena de Objetos --");
        //do {
          //  menuP();
          //  subMenuP(opMP);
       // } while (opMP != 0);
        Principal janelaP = new Principal();
        janelaP.setVisible(true);
    }// fim main

    public static void menuP() {// menu principal

        String menu = "1 - Criar Personagem"
                + "\n2 - Listar Personagens"
                + "\n3 - Batalha(lista guerreiro)"
                + "\n0 - Sair do Jogo(Lista ladrao)"
                + "\nDigite a opção: ";

        System.out.print(menu);
        opMP = lerInt();
    }// fim menu

    public static void subMenuP(int omP) {
        System.out.println("\n-- SubMenu--");
        switch (omP) {
            case 1:
                System.out.print("1- Guerreiro"
                        + "\n2 - Ladrão"
                        + "\n3 - Vítima"
                        + "\nDigite a opção: ");
                int opSB = lerInt();
                criarPersona(opSB);
                break;
            case 2:
                System.out.print("Lista de Personagens RAM: ");
                System.out.println("\n" + guerreiros.toString() + "\n" + ladroes.toString() + "\n" + vitimas.toString());
                System.out.println("--Lista bonita--\n");
                for (Guerreiro g : guerreiros) {
                    System.out.println(g.getNome());
                    System.out.println("\tPontos de Vida: " + g.getPontoDeVida());
                    System.out.println("\tArmamento: " + g.getArmamento());
                }
                for (Ladrao l : ladroes) {
                    System.out.println(l.getNome());
                    System.out.println("\tPontos de Vida: " + l.getPontoDeVida());
                    System.out.println("\tOlho: " + l.getOlho());

                }
                for (Pessoa v : vitimas) {
                    System.out.println(v.getNome());
                    System.out.println("\tPontos de Vida: " + v.getPontoDeVida());
                    System.out.println("\tOlho: " + v.getOlho());
                }
                System.out.println("-Vítimas do Banco de Dados-");
                VitimaServicos vs = ServicosFactory.getVitimaServicos();
                System.out.println(vs.listaVitimas().toString());

                System.out.println("\n--Teste de busca por nome--");
                System.out.println(vs.buscaVitimaByNome("%Dani%").toString());

                //teste de update, busca pelo nome e atualiza cabelo
                Pessoa vUp = vs.buscaVitimaByNome("%Dani%");
                vUp.setCabelo("Rosa");
                vs.atualizarVitima(vUp);
                System.out.println("\n--Vítima atualizada--");
                System.out.println(vs.buscaVitimaByNome("%Dani%").toString());

                //deletar vitima apartir do id pelo busca nome
                System.out.println("--Deletar vitima Henry--");
                int id = vs.buscaVitimaByNome("%Henry%").getId();
                //executa atualização no banco
                if (vs.deletarVitima(id)) {
                    System.out.println("Vítima deletada com sucesso!");
                }else{
                    System.out.println("Erro ao deletar vítima!");
                }

                break;
            case 3:
            System.out.println("--CRUD Guerreiro--");
                System.out.println("-Guerreiros do Banco de Dados-");
                GuerreiroServicos gs = ServicosFactory.getGuerreiroServicos();
                System.out.println(gs.listaGuerreiros().toString());

                System.out.println("\n--Teste de busca por nome--");
                System.out.println(gs.buscaGuerreiroByNome("%Marceline%").toString());

                //teste de update, busca pelo nome e atualiza cabelo
                Guerreiro gUp = gs.buscaGuerreiroByNome("%Louis%");
                gUp.setCabelo("Azul");
                gs.atualizarGuerreiro(gUp);
                System.out.println("\n--Guerreiro atualizado--");
                System.out.println(gs.buscaGuerreiroByNome("%Louis%").toString());
                
                //deletar guerreiro apartir do id pelo busca nome
                System.out.println("--Deletar guerreiro Harry--");
                int idg = gs.buscaGuerreiroByNome("%Harry%").getId();
                //executa atualização no banco
                if (gs.deletarGuerreiro(idg)) {
                    System.out.println("Guerreiro deletado com sucesso!");
                }else{
                    System.out.println("Erro ao deletar Guerreiro!");
                }
                break;
            case 0:
                


                break;
            default:
                System.out.println("Opção inválida, tente novamente!");
                break;
        }// fim sub

    }// fim void submenu

    private static void criarPersona(int opSM) {
        switch (opSM) {
            case 1:
                System.out.println("Criar Guerreiro!");
                Guerreiro g = new Guerreiro();
                System.out.print("Informe o nome do Guerreiro: ");
                g.setNome(ler.nextLine());
                System.out.print("Informe a cor do olho: ");
                g.setOlho(ler.nextLine());
                System.out.print("Informe a cor do cabelo: ");
                g.setCabelo(ler.nextLine());
                System.out.print("Informe a cor da pele: ");
                g.setPele(ler.nextLine());
                System.out.print("Informe o sexo: "
                        + "\n0 - Feminino"
                        + "\n1 - Masculino"
                        + "\nDigite aqui: ");

                int sexoInt = lerInt();
                boolean sexo;
                if (sexoInt == 0) {
                    sexo = false;// masculino
                } else {
                    sexo = true;// feminino
                }
                g.setSexo(sexo);
                System.out.print("Informe o armamento: ");
                g.setArmamento(ler.nextLine());
                guerreiros.add(g);//arraylist
                // instanciar vitima serviços
                GuerreiroServicos gs = ServicosFactory.getGuerreiroServicos();
                // envia para BD
                gs.cadastrarGuerreiro(g);
                break;
            case 2:
                // System.out.println(guerreiros.toString());
                System.out.println("Criar Ladrão!");
                Ladrao l = new Ladrao();
                System.out.print("Informe o nome do Ladrão: ");
                l.setNome(ler.nextLine());
                System.out.print("Informe a cor do olho: ");
                l.setOlho(ler.nextLine());
                System.out.print("Informe a cor do cabelo: ");
                l.setCabelo(ler.nextLine());
                System.out.print("Informe a cor da pele: ");
                l.setPele(ler.nextLine());
                System.out.print("Informe o sexo: "
                        + "\n0 - Feminino"
                        + "\n1 - Masculino"
                        + "\nDigite aqui: ");

                int sexoIntL = lerInt();
                boolean sexoL;
                if (sexoIntL == 0) {
                    sexo = false;// masculino
                } else {
                    sexo = true;// feminino
                }
                l.setSexo(sexo);
                ladroes.add(l);//arraylist
                // instanciar vitima serviços
                        //LadraoServicos ls = ServicosFactory.getLadraoServicos();
                // envia para BD
                        //ls.cadastrarLadrao(l);
                break;
            case 3:
                System.out.println("Criar Vítima!");
                Pessoa v = new Pessoa();
                System.out.print("Informe o nome da Vítima: ");
                v.setNome(ler.nextLine());
                System.out.print("Informe a cor do olho: ");
                v.setOlho(ler.nextLine());
                System.out.print("Informe a cor do cabelo: ");
                v.setCabelo(ler.nextLine());
                System.out.print("Informe a cor da pele: ");
                v.setPele(ler.nextLine());
                System.out.print("Informe o sexo: "
                        + "\n0 - Feminino"
                        + "\n1 - Masculino"
                        + "\nDigite aqui: ");

                int sexoIntV = lerInt();
                boolean sexoV;
                if (sexoIntV == 0) {
                    sexo = false;// masculino
                } else {
                    sexo = true;// feminino
                }
                v.setSexo(sexo);
                vitimas.add(v);// add no arraylist
                // instanciar vitima serviços
                VitimaServicos vs = ServicosFactory.getVitimaServicos();
                // envia para BD
                vs.cadastrarVitima(v);
                break;
            default:
                System.out.println("Opção inválida, tente novamente!");
                subMenuP(opMP);
                break;
        }

    }
}
