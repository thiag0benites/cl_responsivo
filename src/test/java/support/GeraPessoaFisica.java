package support;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;

public class GeraPessoaFisica {
	
	public String nome(String genero) {
		
		String feminino[] = {"Alice", "Sophia", "Júlia", "Laura", "Isabella", "Manuela", "Luiza", "Helena", "Valentina", "Giovanna", "Maria Eduarda", "Beatriz", "Maria Clara", "Maria Luiza", "Heloísa", "Mariana", "Lara", "Lívia", "Lorena", "Ana Clara", "Isadora", "Rafaela", "Sarah", "Yasmin", "Ana Luiza", "Letícia", "Nicole", "Gabriela", "Isabelly", "Melissa", "Cecília", "Esther", "Ana Júlia", "Emanuelly", "Clara", "Marina", "Rebeca", "Vitória", "Isis", "Lavínia", "Maria", "Bianca", "Ana Beatriz", "Larissa", "Maria Fernanda", "Catarina", "Alícia", "Maria Alice", "Amanda", "Ana", "Milena", "Carolina", "Elisa", "Eduarda", "Ana Laura", "Laís", "Agatha", "Emilly", "Pietra", "Maria Júlia", "Fernanda", "Eloá", "Maitê", "Luna", "Maria Cecília", "Stella", "Gabrielly", "Olívia", "Bárbara", "Antonella", "Luana", "Liz", "Clarice", "Sophie", "Natália", "Camila", "Maya", "Mariah", "Bruna", "Maria Vitória", "Mirella", "Ana Sophia", "Isabel", "Ayla", "Malu", "Antônia", "Alana", "Marcela", "Joana", "Maria Valentina", "Maysa", "Ana Carolina", "Micaela", "Juliana", "Ana Lívia", "Maria Sophia", "Débora", "Caroline", "Louise", "Maria Antônia"};
		String masculino[] = {"Miguel", "Arthur", "Davi", "Pedro", "Bernardo", "Gabriel", "Lucas", "Matheus", "Heitor", "Rafael", "Enzo", "Nicolas", "Lorenzo", "Guilherme", "Samuel", "Theo", "Felipe", "Gustavo", "Henrique", "João Pedro", "João Lucas", "Daniel", "Murilo", "Vitor", "Pedro Henrique", "Eduardo", "Leonardo", "Pietro", "Benjamin", "Isaac", "João", "Joaquim", "Lucca", "Caio", "Vinicius", "Cauã", "Bryan", "João Miguel", "Vicente", "Francisco", "Antônio", "Benício", "João Vitor", "Enzo Gabriel", "Davi Lucas", "Davi Lucca", "Thiago", "Thomas", "Emanuel", "Enrico", "Otávio", "João Gabriel", "Davi Luiz", "Nathan", "Yuri", "Ian", "Anthony", "Bruno", "Augusto", "Bento", "Rodrigo", "Erick", "Gael", "Calebe", "Luiz Felipe", "Fernando", "Igor", "Kaique", "Ryan", "Levi", "André", "Noah", "Carlos Eduardo", "Alexandre", "Vitor Hugo", "Henry", "Raul", "Breno", "Luan", "Pedro Lucas", "Luiz Miguel", "João Guilherme", "Luiz Henrique", "Luiz Gustavo", "Cauê", "Mathias", "Diogo", "Yago", "Martim", "Diego", "Adrian", "Thales", "Santiago", "Ricardo", "Marcelo", "José", "Danilo", "Juan", "Estevão", "Pedro Miguel"};
		String sobreNome[] = {"Muniz", "Schumacher", "Mazzaropi", "Monteiro", "Müller", "Marques", "Moraes", "Duarte", "Vasconcelos", "Montenegro", "Fagundes", "Trindade", "Vargas", "Ferraz", "Carvalho", "Dolabella", "Evelyn", "Reymond", "Lins", "Andrade", "Boaventura", "Barcellos", "Dantas", "Oliveira", "Carvalho", "Vilela", "Santana", "Ribeiro", "Barros", "Moscovis", "Gonçalves", "Johnson", "Castro", "Assunção", "Kannenberg", "Torres", "Gomes", "Alves", "Steves", "Garcia", "Moura", "Albuquerque", "Antunes", "Barcelos", "Roriz", "Ferrari", "Castiel", "Fischer", "Novaes", "Gimenez", "Schoemberger", "Falabella", "Martins", "Drummond", "Figueiredo", "Resende", "Sampaio", "Fernandes", "Cavalcante", "Arantes", "Lombardi", "Dieckmann", "Góes", "Menezes", "Ganzarolli", "Guimarães", "Liberato", "Alencar", "Marinho", "Lambertini", "Lafaiete", "Sanches", "Timberg", "Bernardi", "Werneck", "Schmütz", "Annenberg", "Campos", "Medeiros", "Lessa", "Hickmann", "ontenelle", "Bittencourt", "Noronha", "Abravanel", "Sheherazade", "Bastos", "Meneghel", "Bonner", "Riche", "Chapelin", "Rios", "Giácomo", "D’Ávila", "Close", "Bial", "Maldonado", "Bongiovanni", "Vitti", "Silverstone"};
		
		String nome = "";
		
		switch (genero.toLowerCase()) {
		case "f":
			nome = feminino[new Random().nextInt(feminino.length)];
			break;

		case "m":
			nome = masculino[new Random().nextInt(masculino.length)];
			break;
		}
		
		return nome  + " " + sobreNome[new Random().nextInt(sobreNome.length)]; 
	}

	public String dataNacimento(boolean comBarras) {
		
		String data = "";
		Random random = new Random();
		
		Locale locale = new Locale("pt","BR");
		GregorianCalendar calendar = new GregorianCalendar();
		SimpleDateFormat formatador = new SimpleDateFormat("yyyy", locale);
		int anoAtual = Integer.parseInt(formatador.format(calendar.getTime()));
		
		int iDia = random.nextInt(28 - 1);
		String dia = iDia == 0 ? String.valueOf(iDia+1) : String.valueOf(iDia);
		int iMes = random.nextInt(12 - 1);
		String mes = iMes == 0 ? String.valueOf(iMes+1) : String.valueOf(iMes);
		int iAno = (random.nextInt(anoAtual-(anoAtual-80)));
		String ano = iAno < 18 ? String.valueOf(anoAtual - (iAno + (18 - iAno))) : String.valueOf(anoAtual - iAno);
		
		dia = dia.length() == 2 ? dia : "0" + dia;
		mes = mes.length() == 2 ? mes : "0" + mes;
		
		if(comBarras) {
			data = dia + "/" + mes + "/" + ano;
		} else {
			data = dia + mes + ano;
		}
		
		return data;
	}
	
    private int randomiza(int n) {
        int ranNum = (int) (Math.random() * n);
        return ranNum;
    }

    private int mod(int dividendo, int divisor) {
        return (int) Math.round(dividendo - (Math.floor(dividendo / divisor) * divisor));
    }

    public String cpf(boolean comPontos) {
        int n = 9;
        int n1 = randomiza(n);
        int n2 = randomiza(n);
        int n3 = randomiza(n);
        int n4 = randomiza(n);
        int n5 = randomiza(n);
        int n6 = randomiza(n);
        int n7 = randomiza(n);
        int n8 = randomiza(n);
        int n9 = randomiza(n);
        int d1 = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;

        d1 = 11 - (mod(d1, 11));

        if (d1 >= 10)
            d1 = 0;

        int d2 = d1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;

        d2 = 11 - (mod(d2, 11));

        String retorno = null;

        if (d2 >= 10)
            d2 = 0;
        retorno = "";

        if (comPontos)
            retorno = "" + n1 + n2 + n3 + '.' + n4 + n5 + n6 + '.' + n7 + n8 + n9 + '-' + d1 + d2;
        else
            retorno = "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + d1 + d2;

        return retorno;
    }

    
}
