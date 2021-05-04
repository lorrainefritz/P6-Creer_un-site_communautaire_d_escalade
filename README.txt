A website to find where you can climb an borrow and / or loan atlas of the areas or crags' routes you want to climb

Deployment: 1 - Create a Postgresql database named BDD_LES_AMIS_DE_LESCALADE - datasource URL: jdbc:postgresql://localhost:5432/BDD_LES_AMIS_DE_LESCALADE- owner ID: postgres- password: 13PommesOranges

2 - Restore the database with file: BackupDB/LesAmisDeLEscalade.backup - don't forget the Restore options>Sections> Pre-data, Data and Post-data must be checked

3 - Please verify that you have Java 8 (at least) installed on your device.

4 - Go to the directory: LesAmisDeLEscalade/webapp/output

5 - Either double-clic on the webapp.jar file or run it from console with the command: java -jar webapp.jar

6 - In a browser, open: http://localhost:8080/

Use the App: You have an admin account ID:  Pomme@gmail.com, 123
You have 1 member account ID Paul@gmail.com, 123
You have 1 user accounts ID: Petter@gmail.com, 123