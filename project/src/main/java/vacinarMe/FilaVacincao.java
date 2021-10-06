package vacinarMe;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

public class FilaVacincao {
    private int id;
    private String nome;
    private int ordemFila;
    private int ordem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getOrdemFila() {
        return ordemFila;
    }

    public void setOrdemFila(int ordemFila) {
        this.ordemFila = ordemFila;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }
}
