package fr.yncrea.cin3.pyramin;

import fr.yncrea.cin3.pyramin.service.PyraminFileService;
import fr.yncrea.cin3.pyramin.service.solvers.PyraminService;
import fr.yncrea.cin3.pyramin.service.solvers.PyraminServiceImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var main = new Main();
        main.run();
    }

    private PyraminFileService fs = new PyraminFileService();

    private void run() throws IOException {
        var content = fs.loadFromFile("5.txt");

        PyraminService service = new PyraminServiceImpl();

        var start = System.nanoTime();
        var result = service.min(content);
        var end = System.nanoTime();

        System.out.println("Result is " + result);
        System.out.println(((end - start) / 1000000) + "ms taken");
    }
}
