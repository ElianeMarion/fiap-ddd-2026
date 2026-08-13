package br.fiap.tests;

import br.fiap.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PrincipalMetodoForEach {
    public static void main(String[] args) {
        Episodio episodio1 = new Episodio(1, "Pilot", 8.5, 1000);
        Episodio episodio2 = new Episodio(2, "Lucifer, Stay. Good Devil", 8.0, 1000);
        Episodio episodio3 = new Episodio(3, "The Would-Be Prince of Darkness", 7.5, 1000);
        Episodio episodio4 = new Episodio(4, "Manly Whatnots", 8.3, 1000);
        Episodio episodio5 = new Episodio(1, "Everything's Coming Up Lucifer", 8.5, 1000);
        Episodio episodio6 = new Episodio(2, "Liar, Liar, Slutty Dress on Fire", 0.0, 1000);
        Episodio episodio7 = new Episodio(3, "Sin-Eater", 7.9, 1000);
        Episodio episodio8 = new Episodio(4, "Lady Parts", 8.3, 1000);


        var temporada1 = new Temporada(1, List.of(episodio1, episodio2, episodio3, episodio4));
        var temporada2 = new Temporada(2, List.of(episodio5, episodio6, episodio7, episodio8));
        List<Temporada> temporadas = new ArrayList<>();
        temporadas.add(temporada1);
        temporadas.add(temporada2);

        Serie lucifer = new Serie("Lucifer", 2016, 50, 8.1, 10, ClassificacaoEnum.DEZOITO,
                5, false, 8, 50, temporadas);
        //for temporada (for episodios)

        /* Nova serie => Stranger
         * */
        List<Episodio> epsS1 = Arrays.asList(
                new Episodio(1, "The Vanishing of Will Byers", 8.5, 200),
                new Episodio(2, "The Weirdo on Maple Street", 8.1, 180)
                // ... adicione os demais
        );
        Temporada temporada1ST = new Temporada(1, epsS1);

        // --- Temporada 2 ---
        List<Episodio> epsS2 = Arrays.asList(
                new Episodio(2, new Episodio(1, "MADMAX", 8.4, 220)), // usando construtor de cópia só p/ demo
                new Episodio(2, "Trick or Treat, Freak", 8.6, 210)
                // ... adicione os demais
        );
        Temporada temporada2ST = new Temporada(2, epsS2);

        // --- Lista de todas as temporadas ---
        List<Temporada> todasAsTemporadas = Arrays.asList(temporada1ST, temporada2ST);

        // --- Série Stranger Things ---
        // número de temporadas = 2; ativa = true; episódios por temporada = cerca de 9; tempo médio ~ 50min

        Serie strangerThings = new Serie("Stranger Things", 2020, 50, 2, true,
                9, 50, todasAsTemporadas);

        //System.out.println(strangerThings);
        List<Serie> series = new ArrayList<>();
        series.add(lucifer);
        series.add(strangerThings);

        Filme filmeA = new Filme();
        filmeA.setNome("Divertidamente 2");
        filmeA.setAnoDeLancamento(2024);
        filmeA.setDuracaoEmMinutos(101);

        Filme filmeB = new Filme();
        filmeB.setNome("Meu malvado favorito 4");
        filmeB.setAnoDeLancamento(2024);
        filmeB.setDuracaoEmMinutos(98);

        Filme filmeC = new Filme();
        filmeC.setNome("Meu malvado favorito 1");
        filmeC.setAnoDeLancamento(2018);
        filmeC.setDuracaoEmMinutos(98);

        List<Filme> filmes = new ArrayList<>();
        filmes.add(filmeA);
        filmes.add(filmeC);
        filmes.add(filmeB);
        System.out.println("============================================");

        // 1. Exibir todas as séries, suas temporadas e episódios
        series.forEach(serie -> {
            System.out.println("Série: " + serie.getNome());
            serie.getTemporadas().forEach(temp -> {
                System.out.println("Temporada " + temp.getNumeroTemporada());
                temp.getEpisodios().forEach(ep ->
                        System.out.println(" Ep " + ep.getNumero() + " - " + ep.getNome())
                );
            });
        });
        System.out.println("============================================");
        System.out.println("1. Exibir todas as séries, suas temporadas e episódios com STREAM");
        series.stream()
                .forEach(serie -> {
                    System.out.println("Série: " + serie.getNome());
                    serie.getTemporadas().stream()
                            .forEach(temp -> {
                                System.out.println("  Temporada " + temp.getNumeroTemporada() + ":");
                                temp.getEpisodios().stream()
                                        .forEach(ep -> System.out.println(
                                                "    Ep " + ep.getNumero() + " — " + ep.getNome()
                                        ));
                            });
                });
        System.out.println("2. Exibir as séries ativas");
        series.forEach(ativa -> {
            if (ativa.isAtiva()) {
                System.out.println("Ativa: " + ativa.getNome());
            }
        });

        System.out.println("============================================");
        System.out.println("Exibir as séries ativas com stream");
        series.stream()
                .filter(Serie::isAtiva)
                .forEach(ativa -> System.out.println("Ativa: " + ativa.getNome()));

        System.out.println("============================================");
        System.out.println("3.  Exibir a quantidade de temporadas por série.");
        series.forEach(s ->
                System.out.println(s.getNome() + " tem " + s.getTemporadas().size() + " temporada(s)")
        );

        System.out.println("============================================");
        System.out.println("4.  Exibir uma lista de séries finalizadas");
        series.forEach(finalizadas -> {
            if (!finalizadas.isAtiva()) {
                System.out.println("Finalizada: " + finalizadas.getNome());
            }
        });
        System.out.println("============================================");
        System.out.println("4.  Exibir uma lista de séries finalizadas com STREAM");
        series.stream()
                .filter(s-> !s.isAtiva())
                .forEach(f-> System.out.println("Finalizada: " + f.getNome()));

        System.out.println("============================================");
        System.out.println("5.  Ao selecionar uma série finalizada, exibir todas as temporadas e seus respectivos episódios.");
        String nomeEscolhido = "Lucifer";

        series.forEach(s -> {
            // Como não usamos Stream e nem o loop "for" tradicional, o controle do "filtro" é feito por IF
            if (!s.isAtiva() && s.getNome().equalsIgnoreCase(nomeEscolhido)) {
                System.out.println(">>> " + s.getNome());
                s.getTemporadas().forEach(temp -> {
                    System.out.println("Temporada: " + temp.getNumeroTemporada());
                    s.getTemporadas().forEach(t ->
                            temp.getEpisodios().forEach(ep ->
                                    System.out.println("Ep: " + ep.getNumero() + " - " + ep.getNome())
                            )
                    );
                });

            }
        });

        System.out.println("============================================");
        System.out.println("6.  Listar os filmes filtrados pelo tempo de duração");
        int duracaoMin = 90;
        int duracaoMax = 120;
        filmes.stream()
                .filter(f-> f.getDuracaoEmMinutos() >= duracaoMin && f.getDuracaoEmMinutos() <= duracaoMax)
                .sorted(Comparator.comparingInt(Filme::getDuracaoEmMinutos))
                .forEach(f-> System.out.println(f.getNome() + " - " + f.getDuracaoEmMinutos() + " min."));

        System.out.println("===============================================");
        System.out.println("7 - Contar quantos episódios têm avaliação acima de 8.0");
        long contador = todasAsTemporadas.stream()
                .flatMap(t-> t.getEpisodios().stream())
                .filter(ep -> ep.getAvaliacao() > 8)
                .count();
        System.out.println("Quantidade de pisódios com avaliação acima de 8: " + contador);

        System.out.println("==========================================================");
        System.out.println("8 - Exibir os melhores episódios de uma temporada de acordo com a avaliação.");
        int temporadaEscolhida = 2;
        series.stream()
                .flatMap(s-> s.getTemporadas().stream())
                .filter(t-> t.getNumeroTemporada() == temporadaEscolhida)
                .flatMap(t-> t.getEpisodios().stream())
                .sorted(Comparator.comparingDouble(Episodio::getAvaliacao).reversed())
                .limit(5)
                .forEach(ep-> System.out.println("Ep " + ep.getNumero() + " - " + ep.getNome() + "("+ ep.getAvaliacao()+")"));



    }
}
