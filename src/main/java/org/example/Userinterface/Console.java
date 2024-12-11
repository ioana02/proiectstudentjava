package org.example.Userinterface;

import org.example.Domain.Student;
import org.example.Service.StudentService;

import java.util.Scanner;

public class Console {
    private final StudentService ss;
    private final Scanner scanner;

    public Console(StudentService ss) {
        this.ss = ss;
        this.scanner = new Scanner(System.in);
    }

    private void printMenu() {
        {
            System.out.println();
            System.out.println("BINE AI VENIT! Ce optiune doresti sa alegi?");
            System.out.println();
            System.out.println("1. cautare dupa id.");
            System.out.println("2. citire carti.");
            System.out.println("3. afisare carti");
            System.out.println("4. filtrare carti dupa gen");
            System.out.println("5. filtrare carti dupa gen si pret");
            System.out.println("6. carti sortate dupa gen");
            System.out.println("7. carti sortate dupa pret,descrescator");
            System.out.println("8. carti sortate dupa autor, titlu.");
            System.out.println("9. Exit.");

        }
    }

    private String readLine(String helper) {
        System.out.print(helper);
        return scanner.nextLine();

    }

    public void start() {

        while (true) {
            loop();
        }
    }

    private void loop() {
        printMenu();
        String string = readLine(">>> ");
        try {

            {
                switch (string) {
                    case "1" -> cautareDupaId();
                    case "2" -> citireCarti();
                    case "3" -> afisarecarti();
                    case "4" -> filtrareStudentiGrupa();
                    case "5" -> filtrareStudentiGrupaMedie();
                    case "6" ->afisareStudentiSortatiNumePrenume();
                    case "7" -> studentiSortatiGrupa();
                    case "8" -> studentiSortatiMedie();
                    case "9" -> System.exit(0);
                    default -> {
                        System.out.println("Optiune gresita, va rugam reincercati!");
                    }
                }
            }

        } catch (Error e) {
            System.out.println(e.getMessage());
        }
    }

    private void cautareDupaId() {
        String idstr = readLine("id: ");
        Long id = Long.parseLong(idstr);
        Student student = ss.findCarteId(id);
        System.out.println(student);
    }

    private void citireCarti() {
        System.out.println(ss.findCarteAll());
    }

    private void afisarecarti() {
        System.out.println(ss.searchByName("pop","ion"));
    }

    private void filtrareStudentiGrupa() {
        ss.filtrareStudentiGrupa().forEach(System.out::println);
    }

    private void filtrareStudentiGrupaMedie() {
        ss.filtrareStudentiGrupaMedie().forEach(System.out::println);
    }

    private void studentiSortatiMedie() {
        ss.sortateDupaMedie().forEach(this::afisare_id_medie);
    }

    private void studentiSortatiGrupa() {
        ss.sortareDupaGrupa().forEach(this::afisare_nume_prenume_grupa);
    }

    private void afisareStudentiSortatiNumePrenume() {
        ss.studentiSortatiDupaNumePrenume().forEach(this::afisare_id_nume_prenume);
    }
    private  void afisare_id_nume_prenume(Student student)
    {
            System.out.println("id:  "+student.getId()+ " nume: "+student.getNume()+" prenume: "+student.getPrenume());

    }
    private  void afisare_nume_prenume_grupa(Student student)
    {
        System.out.println("nume: "+student.getNume()+" prenume: "+student.getPrenume()+" grupa: "+student.getGrupa());
    }
    private  void afisare_id_medie(Student student)
    {
        System.out.println(" id: "+student.getId()+" medie: "+student.getMedia());
    }
}
