import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Abstract factory: WordFactory
abstract class WordFactory {
    public abstract Panel CreatePanel();
    public abstract Button CreateButton();
    public abstract Textbox CreateTextbox();
}

// Concrete factory: Word90Factory
class Word90Factory extends WordFactory {
    private static int count = 0;
    private Word90Factory() {}

    // Implement Singleton pattern
    public static Word90Factory getInstance() {
        if (count < 2) {
            count++;
            return new Word90Factory();
        }
        else {
            System.out.println("Warning: Word90Factory already instantiated 2 times");
            return null;
        }
    }

    @Override
    public Panel CreatePanel() {
        return new Word90Panel();
    }

    @Override
    public Button CreateButton() {
        return new Word90Button();
    }

    @Override
    public Textbox CreateTextbox() {
        return new Word90Textbox();
    }
}

// Concrete factory: Word00Factory
class Word00Factory extends WordFactory {
    private static int count = 0;
    private Word00Factory() {}

    // Implement Singleton pattern
    public static Word00Factory getInstance() {
        if (count < 2) {
            count++;
            return new Word00Factory();
        }
        else {
            System.out.println("Warning: Word00Factory already instantiated 2 times");
            return null;
        }
    }

    @Override
    public Panel CreatePanel() {
        return new Word00Panel();
    }

    @Override
    public Button CreateButton() {
        return new Word00Button();
    }

    @Override
    public Textbox CreateTextbox() {
        return new Word00Textbox();
    }
}

// Concrete factory: Word10Factory
class Word10Factory extends WordFactory {
    private static int count = 0;
    private Word10Factory() {}

    // Implement Singleton pattern
    public static Word10Factory getInstance() {
        if (count < 2) {
            count++;
            return new Word10Factory();
        }
        else {
            System.out.println("Warning: Word10Factory already instantiated 2 times");
            return null;
        }
    }

    @Override
    public Panel CreatePanel() {
        return new Word10Panel();
    }

    @Override
    public Button CreateButton() {
        return new Word10Button();
    }

    @Override
    public Textbox CreateTextbox() {
        return new Word10Textbox();
    }
}

// Concrete factory: Word24Factory
class Word24Factory extends WordFactory {
    private static int count = 0;
    private Word24Factory() {}

    // Implement Singleton pattern
    public static Word24Factory getInstance() {
        if (count < 2) {
            count++;
            return new Word24Factory();
        }
        else {
            System.out.println("Warning: Word24Factory already instantiated 2 times");
            return null;
        }
    }

    @Override
    public Panel CreatePanel() {
        return new Word24Panel();
    }

    @Override
    public Button CreateButton() {
        return new Word24Button();
    }

    @Override
    public Textbox CreateTextbox() {
        return new Word24Textbox();
    }
}

// Abstract product: Panel
abstract class Panel {
    public abstract void DisplayName(Panel panel);
}

// Abstract product: Button
abstract class Button {
    public abstract void DisplayName(Button button);
}

// Abstract product: Textbox
abstract class Textbox {
    public abstract void DisplayName(Textbox textbox);
}

// Concrete product: Word90Panel
class Word90Panel extends Panel {
    @Override
    public void DisplayName(Panel panel) {
        System.out.println("Panel Word90");
    }
}

// Concrete product: Word90Button
class Word90Button extends Button {
    @Override
    public void DisplayName(Button button) {
        System.out.println("Button Word90");
    }
}

// Concrete product: Word90Textbox
class Word90Textbox extends Textbox {
    @Override
    public void DisplayName(Textbox textbox) {
        System.out.println("Textbox Word90");
    }
}

// Concrete product: Word00Panel
class Word00Panel extends Panel {
    @Override
    public void DisplayName(Panel panel) {
        System.out.println("Panel Word00");
    }
}

// Concrete product: Word00Button
class Word00Button extends Button {
    @Override
    public void DisplayName(Button button) {
        System.out.println("Button Word00");
    }
}

// Concrete product: Word00Textbox
class Word00Textbox extends Textbox {
    @Override
    public void DisplayName(Textbox textbox) {
        System.out.println("Textbox Word00");
    }
}

// Concrete product: Word10Panel
class Word10Panel extends Panel {
    @Override
    public void DisplayName(Panel panel) {
        System.out.println("Panel Word10");
    }
}

// Concrete product: Word10Button
class Word10Button extends Button {
    @Override
    public void DisplayName(Button button) {
        System.out.println("Button Word10");
    }
}

// Concrete product: Word10Textbox
class Word10Textbox extends Textbox {
    @Override
    public void DisplayName(Textbox textbox) {
        System.out.println("Textbox Word10");
    }
}

// Concrete product: Word24Panel
class Word24Panel extends Panel {
    @Override
    public void DisplayName(Panel panel) {
        System.out.println("Panel Word24");
    }
}

// Concrete product: Word24Button
class Word24Button extends Button {
    @Override
    public void DisplayName(Button button) {
        System.out.println("Button Word24");
    }
}

// Concrete product: Word24Textbox
class Word24Textbox extends Textbox {
    @Override
    public void DisplayName(Textbox textbox) {
        System.out.println("Textbox Word24");
    }
}

// Client
class Client {
    private Panel panel;
    private Button button;
    private Textbox textbox;

    // Constructor
    public Client(WordFactory wordFactory) {
        panel = wordFactory.CreatePanel();
        button = wordFactory.CreateButton();
        textbox = wordFactory.CreateTextbox();
    }

    public void Run() {
        panel.DisplayName(panel);
        button.DisplayName(button);
        textbox.DisplayName(textbox);
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> generations = readConfigurationFile("config.txt");
        if (generations == null) {
            System.out.println("Error reading configuration file.");
            return;
        }

        for (String generation : generations) {
            System.out.println("Testing " + generation + "...");
            WordFactory factory = getFactory(generation);
            if (factory != null) {
                Client client = new Client(factory);
                client.Run();
            }
            System.out.println();
        }
    }

    private static List<String> readConfigurationFile(String filename) {
        List<String> generations = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                generations.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return generations;
    }

    private static WordFactory getFactory(String generation) {
        switch (generation) {
            case "Word90":
                return Word90Factory.getInstance();
            case "Word00":
                return Word00Factory.getInstance();
            case "Word10":
                return Word10Factory.getInstance();
            case "Word24":
                return Word24Factory.getInstance();
            default:
                System.out.println("Unknown generation: " + generation);
                return null;
        }
    }
}
