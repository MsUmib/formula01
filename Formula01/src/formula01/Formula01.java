package formula01;
public class Formula01 {
    public static void main(String[] args) {
        System.out.println("");
    }
    
}
/*
-- pais (sigla, nome)
CREATE TABLE pais (
    sigla CHAR(2) NOT NULL, 
    nome VARCHAR(30) NOT NULL,
    CONSTRAINT pk_pais PRIMARY KEY(sigla)
)

--equipe (codigo, nome, #sigla_pais)
--sigla_pais referencia pais (sigla)
CREATE TABLE equipe (
   codigo SERIAL NOT NULL,
   nome VARCHAR(30) NOT NULL,
   sigla_pais CHAR(2) NOT NULL,
   CONSTRAINT pk_equipe PRIMARY KEY(codigo),
   CONSTRAINT fk_equipe_pais FOREIGN KEY(sigla_pais) REFERENCES pais(sigla)
);

--circuito (codigo, nome, #sigla_pais)
--sigla_pais referencia pais (sigla)
CREATE TABLE circuito (
	codigo SERIAL NOT NULL,
	nome VARCHAR(30) NOT NULL,
	sigla_pais CHAR(2) NOT NULL,
	CONSTRAINT pk_circuito PRIMARY KEY(codigo),
	CONSTRAINT fk_circuito_pais FOREIGN KEY(sigla_pais) REFERENCES pais(sigla)
);
--piloto (codigo, nome, #sigla_pais, #codigo_equipe)
--sigla_pais referencia pais (sigla)
--codigo_equipe referencia equipe (codigo)
CREATE TABLE piloto (
	codigo SERIAL NOT NULL,
	nome VARCHAR(30) NOT NULL,
	sigla_pais CHAR(2) NOT NULL,
	codigo_equipe INT NOT NULL,
	CONSTRAINT pk_piloto PRIMARY KEY(codigo),
	CONSTRAINT fk_piloto_pais FOREIGN KEY (sigla_pais) REFERENCES pais(sigla),
	CONSTRAINT fk_piloto_equipe FOREIGN KEY (codigo_equipe) REFERENCES equipe(codigo)
);
--corrida (data, #cod_circuito)
--cod_circuito referencia circuito (codigo)

CREATE TABLE corrida (
	data DATE NOT NULL,
	codigo_circuito INT NOT NULL,
	CONSTRAINT pk_corrida PRIMARY KEY(data),
	CONSTRAINT fk_corrida_circuito FOREIGN KEY (codigo_circuito) REFERENCES circuito(codigo)
);
--piloto_corrida (#cod_piloto, #data_corrida, posição, tempo)
--cod_piloto referencia piloto (codigo)
--data_corrida referencia corrida (data
CREATE TABLE piloto_corrida (
	posicao INT NOT NULL,
	tempo TIME NOT NULL,
	codigo_piloto INT NOT NULL,
	data_corrida DATE NOT NULL,
	CONSTRAINT pk_piloto_corrida PRIMARY KEY(codigo_piloto, data_corrida),
	CONSTRAINT fk_pc_piloto FOREIGN KEY (codigo_piloto) REFERENCES piloto(codigo),
	CONSTRAINT fk_pc_corrida FOREIGN KEY (data_corrida) REFERENCES corrida(data)
);
*/
