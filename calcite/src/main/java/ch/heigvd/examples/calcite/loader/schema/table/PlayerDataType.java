package ch.heigvd.examples.calcite.loader.schema.table;

import org.apache.calcite.linq4j.Enumerator;

import java.io.Serializable;
import java.util.List;


public class PlayerDataType implements Serializable {
    private int id;
    private String name;
    private int level;


    public PlayerDataType(int id, String name, int level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public PlayerDataType(Object[] current) {
        this.id = (int) current[0];
        this.name = (String) current[1];
        this.level = (int) current[2];
    }

    public static Enumerator<PlayerDataType> enumerator(List<PlayerDataType> data) {
        return new Enumerator() {

            int i = 0;

            @Override
            public PlayerDataType current() {
                Object current = data.get(i);

                if(current.getClass().isArray()){
                    return new PlayerDataType((Object[]) current);
                }
                return (PlayerDataType) current;
            }

            @Override
            public boolean moveNext() {
                if(i >= data.size()-1){
                    return false;
                }

                ++i;
                return true;
            }

            @Override
            public void reset() {
                i = -1;
            }

            @Override
            public void close() {

            }
        };
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
}

