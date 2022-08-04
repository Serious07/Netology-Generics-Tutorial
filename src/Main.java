import magicBox.MagicBox;
import magicBox.MagicBoxWithName;
import interfaces.Nameble;

public class Main {
    public static void main(String[] args) {
        MagicBox<Integer> magicBoxNumbers = new MagicBoxWithName(3, "Коробка с числами");

        magicBoxNumbers.add(10);
        magicBoxNumbers.add(20);

        // Есди коробка не заполнена польностью будет рантайм ошибка
        // System.out.println(magicBoxNumbers.pick());

        magicBoxNumbers.add(30);

        pickRandomItemFromBox(magicBoxNumbers, 5);

        MagicBox<String> magicBoxStrings = new MagicBoxWithName(3, "Коробка со строками");

        System.out.println();

        if (magicBoxStrings instanceof Nameble) {
            System.out.println("Добавление предметов в коробку " + ((Nameble) magicBoxStrings).getName());
        }

        for (int i = 0; i < 4; i++) {
            if (magicBoxStrings.add("Предмет " + (i + 1))) {
                System.out.println("Предмет добавлен!");
            } else {
                System.out.println("Предмет не может быть добавлен! Коробка забита!");
            }
        }

        pickRandomItemFromBox(magicBoxStrings, 5);
    }

    private static void pickRandomItemFromBox(MagicBox box, int repeat) {
        System.out.println();
        if (box instanceof Nameble) {
            System.out.println("Содержимое коробки " + ((Nameble) box).getName() + ":");
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(box.pick());
        }
    }
}
