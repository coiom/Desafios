private static void lerXml() {
	FileReader reader = null;
	try {
		//carrega o arquivo XML para um objeto reader
		reader = new FileReader("C:\\TutorialArquivos\\gerarXml002.xml");
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	//Cria o objeto xstream
	XStream xStream = new XStream(new DomDriver());
	//informamos as tags que serao lidas
	//como foi feito no metodo gerarXml002
	xStream.alias("Contato", Contato.class);
	xStream.aliasField("Endereco", Contato.class, "endereco");
	xStream.aliasField("Telefones", Contato.class, "telefones");
	xStream.alias("Telefone", Telefone.class);
	//cria um objeto Contato,
	//contendo os dados do xml
	Contato contato = (Contato) xStream.fromXML(reader);
	//Exibimos no console o resultado
	System.out.println(contato.toString());
}