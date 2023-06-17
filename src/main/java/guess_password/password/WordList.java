package guess_password.password;

import java.util.List;

public class WordList {
//    wywalić polskie znaki
    private static List<String> WORDS = List.of(
            "abc",
            "co nagle to po diable",
            "czego Jas sie nie nauczy tego Jan nie bedzie umial",
            "gdzie kucharek szesc tam nie ma co jesc",
            "gdzie raki zimuja tam woda nie zamarza",
            "kto mieczem wojuje od miecza ginie",
            "lepszy wrobel w garsci niz golab na dachu",
            "nie chwal dnia przed zachodem slonca",
            "nie wszystko zloto co sie swieci",
            "od zawsze ciernie maja kolce",
            "pieniadz szczescia nie daje",
            "prawdziwych przyjaciol poznaje sie w biedzie",
            "slowo sie rzeklo konca niema",
            "szukajcie a znajdziecie",
            "wszystko jest dla ludzi",
            "zawsze chodzi o to samo",
            "zmienic cos na lepsze",
            "bez pracy nie ma kolaczy",
            "darowanemu koniowi w zeby sie nie zaglada",
            "kto nie ryzykuje ten nie ma nic"
    );

    public static List<String> getWORDS() {
        return WORDS;
    }
}
