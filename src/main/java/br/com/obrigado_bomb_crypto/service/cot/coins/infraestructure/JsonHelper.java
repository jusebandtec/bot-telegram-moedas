package br.com.obrigado_bomb_crypto.service.cot.coins.infraestructure;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;

public class JsonHelper<T> {

    private Gson gson;

    public JsonHelper() {
        this.gson = new Gson();
    }

    public T safeSerializeFromFile(File json, Class<T> jsonClassType) {
        try {
            return serializeFromFile(json, jsonClassType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public T serializeFromFile(File json, Class<T> jsonClassType) throws IOException
    {
        return gson.fromJson(Files.asCharSource(json, Charsets.UTF_8).read(), jsonClassType);
    }

    public String serializeToJson(T objeto) {
        return gson.toJson(objeto);
    }

    public T deserializeFromString(String json, Class<T> jsonClassType) {
        return this.gson.fromJson(json, jsonClassType);
    }
}
