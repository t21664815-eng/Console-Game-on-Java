import java.util.Scanner;

public class Game {
    int status = 0;
    int[] inventory = {1, 2, 9, 9, 9};
    byte byteinfo, buffer, cartridges, double_barreled_shotgun;

    public void game(Scanner in) {
        String name;

        status = start();

        if (status == 1) {
            name = name(in);
            story(in, name);
        }
    }

    int start() {
        int progress = 1;
        System.out.print("------------------------------");
        for (int cycle = 0; cycle < 100; cycle++) {
            System.out.print("\rLoad... " + progress + "%");
            progress++;
        }
        cartridges = 6;
        double_barreled_shotgun = 2;
        System.out.println();
        System.out.println("------------------------------");
        return 1;
    }

    String name(Scanner in) {  // ← принимает Scanner
        System.out.print("Для вашего удобства введите никнейм - ");
        String name = in.nextLine();
        System.out.println("------------------------------");
        return name;
    }

    int story(Scanner in, String playerName) {  // ← принимает Scanner
        System.out.println("""
                Вы - охотник на крупную дичь.
                ««« Не так давно в лесу неподалёку участились случаи пропажи собак, а ещё... людей...
                Из леса ночью иногда доносятся протяжные крики, а если верить словам многих выживших
                То ещё в глубине леса слышны голоса пропавших »»»
                *Ваш взгляд напряжён, вы медленно переворачиваете страницу...*
                ««« Комментарий от представителя местного отдела МВД о сложившейся ситуации.
                "
                Мы в курсе о пропажах людей и ведём активные поиски, лес опечатан для Вашей безопасности.
                " Михаил Димегчив
                »»»
                 *Вы резко сминаете газету и выкидываете в огонь.*
                 *Пока газета догорает вы берёте гранёный стакан с чаем со стола и подходите к окну которое выходит на таинственный лес.*
                 Ищут... Ага, та пока они искать будут, ещё с десяток пропадёт без вести...
                 *Вы допиваете чай, стеклянный стакан в руке*
                 *Вы резко бросаете и разбиваете стакан об стену, Ваш взгляд падает на висящую на стене двухстволку...*
                 Ну, пропавших я уже не спасу, но обязан пристрелить ту тварину, чем бы она не была...
                 *Вы, взяв двухстволку и пару пачек патрон, выдвинулись в лес*
                """);

        System.out.println("Напишите «Продолжить» если вы уже ознакомились.");
        String con = in.nextLine();

        if (con.equals("Продолжить")) {
            clear_chat();
            forest(in);
        } else {
            clear_chat();
            forest(in);
        }
        return 1;
    }

    public void clear_chat() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public void chat_controller(int a) {
        for (int i = 0; i < a; i++) {
            System.out.println();
        }
    }

    public void texthelper(String a, int b) {
        switch (b) {
            case 1 -> {
                System.out.println("_______________________________________");
                System.out.println(a);
                System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                break;
            }
            case 2 -> {
                System.out.println("========================================");
                System.out.println(a);
                System.out.println("========================================");
                break;
            }
            case 3 -> {
                System.out.println("ΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞ");
                System.out.println(a);
                System.out.println("ΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞ");
            }
        }
    }

    public void format() {
        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
    }

    public void formatext() {
        System.out.println("ΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞ");
    }

    void new_item(int item_id){

    }

    int Inventory() {
        System.out.println("3 - Открыть инвентарь");
        return 0;
    }

    int Tabel(Scanner in, int id) {  // ← принимает Scanner
        int Result = 0;
        clear_chat();
        System.out.println("""
                Ваш инвентарь.
                Вы можете всегда открыть его введя цифру 3.
                """);

        if (inventory[0] == 1) {
            System.out.println("Двустволка. Количество патрон в стволах - " + double_barreled_shotgun);
        }
        if (inventory[1] == 2) {
            System.out.println("Коробка патрон для двустволки. Количество патрон внутри - " + cartridges);
        }

        for (int forint = 0; forint < inventory.length; forint++) {
            if (inventory[forint] == 9) {
                int inv = forint + 1;
                System.out.println("В слоте " + inv + " пусто");
            }
            if (inventory[forint] == 3) {
                System.out.println("Нож");
            }
            if (inventory[forint] == 4) {
                System.out.println("Бутылка водки(Аптечка, позволяет восстановить здоровье)");
            }
            if (inventory[forint] == 5) {
                System.out.println("Топор, старый, ржавый, но им можно выбить дверь или заготовить дров на разведение огня.");
            }
            if (inventory[forint] == 6) {
                System.out.println("Канистра бензина. Зажигалки или спичек в комплект юного пироманьяка не входит");
            }
            if (inventory[forint] == 7) {
                System.out.println("Старые спички. Бензина в комплекте нет.");
            }
        }

        System.out.print("Для выхода введите 1 - ");
        byte exit = in.nextByte();
        in.nextLine();

        if (exit == 1) {
            clear_chat();
            comeback(in, id);
        }
        return Result;
    }

    void comeback(Scanner in, int id) {
        //if (id == )
        if (id == 1) forest(in);
        if (id == 2) one(in);
        if (id == 3) Left(in);
        if (id == 4) water_well(in);
        if (id == 5) Rake(in);

    }

    void forest(Scanner in) {
        System.out.println("""
                ΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞ
                Вы стоите у входа в лес. До заката ещё несколько десятков минут.
                Каковы будут Ваши действия?
                ΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞ
                """);
        System.out.println("1 - Войти в лес в этом месте.");
        System.out.println("2 - Обойти лес и поискать ещё место где можно войти");
        Inventory();

        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        System.out.println("Для выбора действия введите его номер.");

        byteinfo = in.nextByte();
        in.nextLine();

        switch (byteinfo) {
            case 1 -> one(in);
            case 2 -> two(in);
            case 3 -> Tabel(in, 1);
        }
    }

    void one(Scanner in) {
        clear_chat();
        formatext();
        System.out.println("""
                Вы идетё в глубь леса уже больше получаса, пока что всё кажется обычным, но это лишь до момента пока не настанет ночь.
                Лес подозрительно тихий, не слышно ни птиц, ни шума ветра, учтя последние обстоятельства вы мысленно готовитесь к худшему...""");
        formatext();
        chat_controller(2);
        texthelper("""
                Перед Вами развилка из двух путей, а солнце всё ниже и ниже спускается по небосводу...
                Что вы выберите? Введите номер действия.""", 2);
        chat_controller(1);
        texthelper("""
                1 - Пойти налево.
                2 - Пойти направо.
                3 - Открыть инвентарь.""", 1);
        byteinfo = in.nextByte();
        in.nextLine();
        switch (byteinfo) {
            case 1 -> Left(in);
            case 2 -> Right(in);
            case 3 -> Tabel(in, 2);
        }
    }

    void two(Scanner in) {
        clear_chat();
        format();
        System.out.println("Вы обошли лес, но не нашли ещё мест где можно войти. \nВам пришлось вернутся назад.");
        format();
        texthelper("Напишите что-либо дабы продолжить...", 2);
        String bufferstring = in.nextLine();
        if (bufferstring.equals("А")) one(in);
        else one(in);
    }

    //Выбор тропинки.
    void Left(Scanner in) {
        clear_chat();
        texthelper("""
                Дорога заняла около получаса, солнце уже почти полностью скрылось за горизонтом...
                Впереди Вы замечаете какой-то колодец.""", 2);
        chat_controller(1);
        texthelper("""
                Что вы выберите?
                1 - Осмотреть колодец.
                2 - Пройти мимо.
                3 - Открыть инвентарь.""", 1);
        buffer = in.nextByte();
        in.nextLine();
        if (buffer == 1)water_well(in);
        if (buffer == 2)Rake(in);
        if (buffer == 3)Tabel(in, 3);

    }
    void water_well(Scanner in){
        clear_chat();
texthelper("""
        Вы подошли к старому колодцу, заглянув, оказалось что воды там нет, что собственно не удивительно, смущает скорее другое...
        Что делает этот колодец в такой глуши?""", 2);
chat_controller(1);
texthelper("""
        Не успев задаться этим вопросом Вы услышали протяжный рёв из глубины леса, и, кажется, оно приближается.
        В голове всплыла отличнейшая мысль - "Нужно поторапливаться.""", 3);
chat_controller(1);
texthelper("""
        Что делать?
        1 - Осмотреть скамью около колодца.
        2 - Осмотреть ведро рядом.
        3 - Открыть инвентарь.""", 1);
        buffer = in.nextByte();
        in.nextLine();
        if (buffer == 1)bench(in);
        if (buffer == 2)bucket(in);
        if (buffer == 3)Tabel(in, 4);
    }

    void Right(Scanner in) {
        clear_chat();
        texthelper("""
                Дорога заняла около получаса, солнце уже почти полностью скрылось за горизонтом...
                Впереди Вы замечаете какой-то старый дом.""", 2);
        chat_controller(1);
        texthelper("""
                Что вы выберите?
                1 - Осмотреть дом.
                2 - Пройти мимо.
                3 - Открыть инвентарь.""", 1);
        buffer = in.nextByte();
        in.nextLine();
        if (buffer == 1)House(in);
        if (buffer == 2)Rake(in);
        if (buffer == 3)Tabel(in, 3);
    }


    void bench(Scanner in){
clear_chat();
texthelper("""
Вы решили осмотреть скамью рядом.
Крик из глубины леса всё ближе и вы решаете поторопится с осмотром.""", 1);
chat_controller(1);
texthelper("Получен предмет *Бутылка водки*", 2);
inventory[3] = 4;
chat_controller(1);
format();
System.out.println("""
Звуки из леса ещё ближе, существо засело в кустах рядом, нужно действовать быстро.
----------------------------------------------------------------------------------
1 - Достать двустволку и выстрелить в кусты.
2 - Достать двустволку и ожидать...
""");
buffer = in.nextByte();
in.nextLine();
switch (buffer){
    case 1 -> Rake(in);
    case 2 -> win();
}}

    void bucket(Scanner in){
        clear_chat();
        texthelper("""
Вы решили осмотреть старое ведро рядом.
Крик из глубины леса всё ближе и вы решаете поторопится с осмотром.""", 1);
        chat_controller(1);
        texthelper("Получен предмет *Нож*", 2);
        inventory[4] = 5;
        chat_controller(1);
        format();
        System.out.println("""
Звуки из леса ещё ближе, существо засело в кустах рядом, нужно действовать быстро.
----------------------------------------------------------------------------------
1 - Достать двустволку и выстрелить в кусты.
2 - Достать двустволку и ожидать...
""");
        buffer = in.nextByte();
        in.nextLine();
        switch (buffer){
            case 1 -> Rake(in);
            case 2 -> win();
        }
    }

    void House(Scanner in){
        clear_chat();
        texthelper("""
        Вы подошли к старому дому, визуально стоит он тут уже давно, смущает скорее другое...
        Что делает этот дом в такой глуши?""", 2);
        chat_controller(1);
        texthelper("""
        Не успев задаться этим вопросом Вы услышали протяжный рёв из глубины леса, и, кажется, оно приближается.
        В голове всплыла отличнейшая мысль - "Нужно поторапливаться.""", 3);
        chat_controller(1);
        texthelper("""
        Что делать?
        1 - Осмотреть скамью около дом.
        2 - Осмотреть стопку дров рядом.
        3 - Открыть инвентарь.""", 1);
        buffer = in.nextByte();
        in.nextLine();
        if (buffer == 1)bench(in);
        if (buffer == 2)firewood(in);
        if (buffer == 3)Tabel(in, 4);
    }

    void firewood(Scanner in){
        clear_chat();
        texthelper("""
Вы решили осмотреть стопку дров рядом.
Крик из глубины леса всё ближе и вы решаете поторопится с осмотром.""", 1);
        chat_controller(1);
        texthelper("Получен предмет *Старый топор*", 2);
        inventory[4] = 5;
        chat_controller(1);
        format();
        System.out.println("""
Звуки из леса ещё ближе, существо засело в кустах рядом, нужно действовать быстро.
----------------------------------------------------------------------------------
1 - Достать двустволку и выстрелить в кусты.
2 - Достать двустволку и ожидать...
""");
        buffer = in.nextByte();
        in.nextLine();
        switch (buffer){
            case 1 -> Rake(in);
            case 2 -> win();
        }
    }

    void Rake(Scanner in){
        clear_chat();
texthelper("Из кустов на Вас резко выскакивает худое белое существо. \nВам не удается успеть перехитрить его...", 2);
chat_controller(15);
fail();
chat_controller(2);
assets();
    }

    void fail() {
        System.out.println("""
                                YOUR DIE!!!
                
                                 uuuuuuu
                             uu$$$$$$$$$$$uu
                          uu$$$$$$$$$$$$$$$$$uu
                         u$$$$$$$$$$$$$$$$$$$$$u
                        u$$$$$$$$$$$$$$$$$$$$$$$u
                       u$$$$$$$$$$$$$$$$$$$$$$$$$u
                       u$$$$$$$$$$$$$$$$$$$$$$$$$u
                       u$$$$$$"   "$$$"   "$$$$$$u
                       "$$$$"      u$u       $$$$"
                        $$$u       u$u       u$$$
                        $$$u      u$$$u      u$$$
                         "$$$$uu$$$   $$$uu$$$$"
                          "$$$$$$$"   "$$$$$$$"
                            u$$$$$$$u$$$$$$$u
                             u$"$"$"$"$"$"$u
                  uuu        $$u$ $ $ $ $u$$       uuu
                 u$$$$        $$$$$u$u$u$$$       u$$$$
                  $$$$$uu      "$$$$$$$$$"     uu$$$$$$
                u$$$$$$$$$$$uu    ""\"""    uuuu$$$$$$$$$$
                $$$$""\"$$$$$$$$$$uuu   uu$$$$$$$$$""\"$$$"
                 ""\"      ""$$$$$$$$$$$uu ""$""\"
                           uuuu ""$$$$$$$$$$uuu
                  u$$$uuu$$$$$$$$$uu ""$$$$$$$$$$$uuu$$$
                  $$$$$$$$$$""\""           ""$$$$$$$$$$$"
                   "$$$$$"                      ""$$$$""
                     $$$"                         $$$$"
                """);
    }
    void win(){
        clear_chat();
        texthelper("Монстр решил резко выпрыгнуть на вас из-за кустов, но он не ожидал что ваша двустволка окажется заряжена...", 3);
        chat_controller(5);
        texthelper("Вы успешно пристрелили монстра и чудом остались живы.", 2);
        win_skulls_bones();
        chat_controller(1);
    }
    void win_skulls_bones(){
        chat_controller(3);
        texthelper("""
                                            ,--.
                                           {    }
                                           K,   }
                                          /  ~Y`
                                     ,   /   /
                                    {_'-K.__/
                                      `/-.__L._
                                      /  ' /`\\_}
                                     /  ' /
                             ____   /  ' /
                      ,-'~~~~    ~~/  ' /_
                    ,'             ``~~~  ',
                   (                        Y
                  {                         I
                 {      -                    `,
                 |       ',                   )
                 |        |   ,..__      __. Y
                 |    .,_./  Y ' / ^Y   J   )|
                 \\           |' /   |   |   ||
                  \\          L_/    . _ (_,.'(
                   \\,   ,      ^^""' / |      )
                     \\_  \\          /,L]     /
                       '-_~-,       ` `   ./`
                          `'{_            )
                              ^^\\..___,.--`
                """, 3);
        assets();

    }
    void assets (){
        chat_controller(2);
        texthelper("""
                Источник ASCI-артов черепов сайт - https://ascii.co.uk/art/skulls
                """, 2);
    }
}