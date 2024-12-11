package org.example.Service;

import org.example.Domain.Student;
import org.example.Domain.Validator;
import org.example.Repository.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentService {
    private final Repository<Long, Student> repCarte;
    private final Validator<Long,Student> validator;
    public List<Student> listaCartei = new ArrayList<>();

    public StudentService(Repository<Long,Student> repCarte, Validator<Long,Student> validator) {
        this.repCarte = repCarte;
        this.validator = validator;
        findCarteAll();
    }
    public Student findCarteId(Long id)
    {
        return repCarte.findOne(id);
    }
    public List<Student> findCarteAll()
    {
        Iterable<Student> listastudenti= repCarte.findAll();
        for (Student s:listastudenti)
        {
            listaCartei.add(s);
        }
        return  listaCartei;
    }
    public  List<Student> searchByName(String nume,String prenume)
    {

        List<Student> lista=new ArrayList<>();
        for (Student s:listaCartei)
        {
            if(s.getNume().equals(nume) && s.getPrenume().equals(prenume))lista.add(s);

        }
        if(lista.size()==0)throw new RuntimeException("nu exista carti cu autor");
        return lista;
    }
    public List<Student> filtrareStudentiGrupa()

    {

        return listaCartei.stream().filter( student -> student.getGrupa().equals("222")).toList();
    }
    public List<Student> filtrareStudentiGrupaMedie()
    {

        Predicate<Student> p1 = n -> Objects.equals(n.getGrupa(),"222");
        Predicate<Student> p2 = n -> n.getMedia() > 5;
        List<Student> filtered = listaCartei.stream().filter(p1.and(p2)).collect(Collectors.toList());
        if (filtered.size() == 0)
            throw new RuntimeException("Nu exista carti de acest gen cu pret mai mare decat 50!");
        return filtered;
    }
    public List<Student> sortateDupaMedie() {

        return listaCartei.stream().sorted(Comparator.comparing(Student::getMedia).reversed()).toList();
    }
    public List<Student>sortareDupaGrupa()

    {

        return listaCartei.stream().sorted(Comparator.comparing(Student::getGrupa)).toList();
    }

    public List<Student> studentiSortatiDupaNumePrenume() {

        Comparator<Student> crieriuSortareNume = Comparator.comparing(Student::getNume);
        Comparator<Student> criteriuSortarePrenume = Comparator.comparing(Student::getPrenume);
        Comparator<Student> criteriuFinal = crieriuSortareNume.thenComparing(criteriuSortarePrenume);
        return listaCartei.stream().sorted(criteriuFinal).toList();
    }

}
