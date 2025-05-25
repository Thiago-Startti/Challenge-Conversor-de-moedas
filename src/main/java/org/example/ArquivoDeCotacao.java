package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoDeCotacao {

    public void salvaJson(Cambio cambio) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escrita = new FileWriter(cambio.moedaOrigem() + cambio.moedaDestino() + ".json");
        escrita.write(gson.toJson(cambio));
        escrita.close();
    }
}
