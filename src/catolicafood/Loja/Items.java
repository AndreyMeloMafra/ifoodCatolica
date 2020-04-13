/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catolicafood.Loja;

/**
 *
 * @author andrey
 */
public class Items {

    private String name;
    private String value;
    private String description;
    private int key;

    public Items(String name, String value, String description, int key) {
        boolean number;
        double va;
        
        try {
            va = Double.parseDouble(value);
            number = true;
        } catch (NumberFormatException e) {
            number = false;
        }
        
        if(number) {
            this.value = value;
        }
        
        this.description = description;
        
        if(key >= 0 || key <= 3) {
            this.key = key;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean alteerValue(String newValue) {
        double v = Double.parseDouble(newValue);
        boolean result = false;

        if (v >= 0) {
            this.value = newValue;
            result = true;
        }

        return result;
    }
    
    @Override
    public String toString() {
        return "name: " + this.name + " - valor: " + this.value + " - descrição: " + this.description;
    }
}
