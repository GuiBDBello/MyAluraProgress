# Java e XML: integração, parsing e validação

## Aula 01 - Representando dados de forma eficiente

### Atividade 01 - Conhecendo o formato XML:

- Formato definido na década de 90 pelo W3C para realizar a comunicação entre sistemas diferentes.
- Organiza informações de forma hierárquica.

### Atividade 02 - Acessando tags de um XML:

- `Document` é o arquivo XML.
- `Element` é a *tag* XML.
- As classes Java utilizadas para trabalhar com XML são provenientes do pacote `org.w3c.dom`.
- **Ex.:**
```
DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = fabrica.newDocumentBuilder();
Document document = builder.parse("src/vendas.xml");

NodeList formasDePagamento = document.getElementsByTagName("formaDePagamento");
Element fdp = (Element) formasDePagamento.item(0);
String formaDePagamento = fdp.getTextContent();
```
- Os elementos do XML podem ser acessados através de `getElementsByTagName("tagName")`, que retorna um `NodeList`.
- Cada elemento dessa lista é representado por uma instância de `Node`. É possível realizar o *cast* de `Node` para `Element`.
- `getTextContent()` retorna o conteúdo do texto contido dentro da *tag*.
- O Java possui diversas especificações, que são conjuntos de interfaces cujo objetivo é desempenhar alguma função. Para manipular XML, temos uma especificação chamada JAXP (Java API for XML Processing).

### Atividade 04 - Criar e acessar atributos:

- E se quisermos incluir também a moeda em que a venda foi realizada? Perceba que a moeda é mais uma informação sobre os dados da venda, como uma meta-informação.
- **Ex.:** (criar um atributo no XML) 
```
<venda moeda="real">
</venda>
```
- O `Document` é uma referência para o "elemento-raíz" do XML.
- **Ex.:** (acessar o atributo com código Java)
```
Element venda = document.getDocumentElement();
String moeda = venda.getAttribute("moeda");
```

## Aula 02 - Garantindo o formato de arquivos XML usando XSD

### Atividade 01 - Validando tags de um XML:

- XSD (*XML Schema Definition*): formato de arquivo que define a sintaxe de um arquivo XML. Descreve a hierarquia do XML.
- No Eclipse, esses arquivos são chamados de *XML Schema File*.
- No arquivo `formatoVenda.xsd`, utilize a *tag* `<element name="tag"/>` para informar quais *tags* devem fazer parte da definição do XML.
- No arquivo `vendas.xml`, adicione o atributo `xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"` (*XML Schema Instance*) com seu valor padrão e o atributo `xsi:noNamespaceSchemaLocation="formatoVenda.xsd"` para vincular o seu XML com o seu XSD.
- No Java, é preciso definir para o `DocumentBuilderFactory` que será utilizado um arquivo XSD. Isso é feito com `factory.setValidating(true);`, `factory.setNamespaceAware(true);` e `factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");`
- **Ex.:**
```
<?xml version="1.0" encoding="UTF-8"?>
<schema xmlns="http://www.w3.org/2001/XMLSchema">
	<element name="venda">
		<complexType>
			<sequence>
				<element name="formaDePagamento" type="string" />
			</sequence>
			<attribute name="moeda" type="string"></attribute>
		</complexType>
	</element>
</schema>
```
- `<complexType>`: define que a venda é um tipo complexo, que pode ter elementos-filhos;
- `<sequence>`: define os elementos-filhos da *tag* venda;
- `<attribute>`: define os atributos da *tag* venda;

### Atividade 02 - Expando nossas validações:

- É possível criar uma hierarquia com vários elementos-filhos.
- **Ex.:**
```
<?xml version="1.0" encoding="UTF-8"?>
<schema xmlns="http://www.w3.org/2001/XMLSchema">
	<element name="venda">
		<complexType>
			<sequence>
				<element name="formaDePagamento" type="string" />
				<element name="produtos">
					<complexType>
						<sequence>
							<element name="produto" maxOccurs="unbounded">
								<complexType>
									<sequence>
										<element name="nome" type="string" />
										<element name="preco" type="double" />
									</sequence>
								</complexType>
							</element>
						</sequence>
					</complexType>
				</element>
			</sequence>
			<attribute name="moeda" type="string"></attribute>
		</complexType>
	</element>
</schema>
```
- É possível desacoplar alguns elementos, como o `produto`, mas para isso é necessário criar um apelido para o *namespace* importado.
- **Ex.:**
```
<?xml version="1.0" encoding="UTF-8"?>
<xsd:schema xmlns:xsd="http://www.w3.org/2001/XMLSchema">
	<xsd:element name="produto">
		<xsd:complexType>
			<xsd:sequence>
				<xsd:element name="nome" type="xsd:string" />
				<xsd:element name="preco" type="xsd:double" />
			</xsd:sequence>
		</xsd:complexType>
	</xsd:element>
	
	<xsd:element name="venda">
		<xsd:complexType>
			<xsd:sequence>
				<xsd:element name="formaDePagamento" type="xsd:string" />
				<xsd:element name="produtos">
					<xsd:complexType>
						<xsd:sequence>
							<xsd:element ref="produto" maxOccurs="unbounded" />
						</xsd:sequence>
					</xsd:complexType>
				</xsd:element>
			</xsd:sequence>
			<xsd:attribute name="moeda" type="xsd:string"></xsd:attribute>
		</xsd:complexType>
	</xsd:element>
</xsd:schema>
```
- Toda vez que um *namespace* externo for utilizado, é uma boa prática dar um apelido para ele.

## Aula 03 - Trabalhando com eventos e SAX

### Atividade 01 - Desempenho do sistema:

- `documentBuilder.parse("src/vendas.xml");`: carrega todo o arquivo `vendas.xml` na memória, possibilitando buscar qualquer *tag* dele.
- Em algumas situações, carregar todo o arquivo em memória pode causar problemas.
