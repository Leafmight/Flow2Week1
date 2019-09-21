#Tuesday - Exercises JPA Relations
##FIL: week1Tuesday1
###Collections of basic types
- Opgaven kan ses i entitetsklassen Customer2.java samt en main metode i Tester2.java.


####JPA Entity Mappings
- Opgaven kan ses i entitetsklasserne Customer.java og Address.java samt CustomerFacade.java og Tester.java.
- Hver opgave er løst og derefter udkommenteret, rækkefølgen følger opgaven.


##### 1) One to One – Unidirectional
- Ændringer i Customer klassen:
		Customer får en reference til Adress id, mens Adress ikke får en ref. til Customer. Foregn Key for Address bliver placeret i Customer.

##### 2) One to One – Bidirectional
- Bidirectional: 2 obj. der "består" af hinanden.
		Hvis man køber en pc vil man måske vide hvilke IT-stuff kunden har købt, men også hvilke kunder der ejer den specifikke pc.
		Der ses ingen ændringer i tabellen, men Address har fået en foreign key til customer.

##### 3) OneToMany - Unidirectional
- Observe the generated code:
		CUSTOMER_ID tabel bliver oprettet med en ref. til addresses (id).

- Run the project and investigate the generated tables. Make sure to press Refresh so see all tables. How many tables were generated? Explain the purpose of each of the tables.
		1 tabel blev genereret - indeholder id der linker Customer og Address.

##### 4) OneToMany - Bidirectional
- Observe the generated code, especially where we find the mappedBy value. Explain.
		mappedBy bliver placeret i Customer, hvor "address" er en ref. til customer der ligger i Address klassen.

- Run the project and investigate the generated tables (the foreign key). 
		FK bliver generet i Address tabellen
- Create a "test" method and insert a number of Customers with Addresses into the tables, using JPA. Which extra step is required for this strategy compared to OneToMany unidirectional?
		Address skal have en ref. til Customer.

##### 5) Many To Many - Bidirectional
- How can we implement ManyToMany relationships in an OO-language like Java?
		OO-sprog kræver vi har en collection attribut for klasse1 til klasse2 og omvendt.

-  How can we implement ManyToMany relationships in a Relational Database?
		Laver en samlet (Joined) tabel der indeholder FK til begge tabeller.

- Observe the generated code and make sure you understand every line generated in BOTH classes.
		Bliver genereret @ManyToMany annotation i begge klasser, samt en mappedBy I Address klassen.


#####Mangler:
- Kunne ikke få facaden til at virke, og havde ikke tid til at kigge på den igen da der var så mange opgaver.


#Wednesday/Thursday - REST with JAX RS
##FIL: week1wed
Det meste af opgaven er lavet efter mål på gul / rød men der var simpelthen for mange ting i denne uge. Der er lavet et par test hist og her med fokus på at de skulle virke mere generelt end bare for de tilfælde vi har.
#####Mangler:
- For all RunTimeExceptions: Kunne ikke få den til at virke så gav op.
- Entity Classes with relations: Nåede nærmest kun lige at lave Address klassen.

#Friday - Object Relational Mapping with JPA
##FIL: Examprob-Friday1
##### General part
 - Explain the rationale behind the topic Object Relational Mapping and the Pros and Cons in using ORM.
 
 
	Pros:
	 - Forhindrer at man laver query fejl i form af forkert syntax.
	 - Der er meget der bliver gjort for en.

<invis></invis>
 
	Cons:
	 - Kræver ikke meget forståelse for database (abstrakt), så ved mere compliceret brug / fejl kan man få problemer.
	 - Tager lidt tid at forstå ORM, men når det bliver brugt er der et "pattern" man kan følge.



- Explain the JPA strategy for handling Object Relational Mapping and important classes/annotations involved.
		Entitet klassen bliver brugt til at skabe Objekter (@Entity annotation). --> kan bruge JPA Framework.
		EntityManagerFaktory "persist"er vores entitet obj. i databasen.
		Selve Kommunikationen til og fra server bliver håndteret gennem Gson/JSON conversion.

 
- Outline some of the fundamental differences in Database handling using plain JDBC versus JPA
		JDBC: Giver mere frihed til at "lege" med databasen.
		JPA: Gør meget for dig + det er hele objektet du smider i databasen.



