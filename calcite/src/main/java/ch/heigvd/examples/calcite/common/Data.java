package ch.heigvd.examples.calcite.common;

import ch.heigvd.examples.calcite.common.schema.table.PlayerDataType;

import java.util.Arrays;
import java.util.List;

public class Data {
    public static final List<Object[]> PLAYER_DATA_AS_OBJECT_ARRAY = Arrays.asList(
            new Object[]{1, "Bertil the great", 99},
            new Object[]{2, "Didier the reckless", 5},
            new Object[]{3, "Daniel the chieftain", 7},
            new Object[]{4, "Nadir the gangster", 7},
            new Object[]{5, "Nohan the cheater", 250},
            new Object[]{6, "Miguel the Valaisan", 8},
            new Object[]{7, "James the spy", 4},
            new Object[]{8, "Adri the smuggler", 6},
            new Object[]{9, "Tony the artist", 9},
            new Object[]{10, "Ludo the beekeeper", 4},
            new Object[]{11, "Gaetan the forever rookie", 1},
            new Object[]{12, "Yanis the comeback of the forever rookie", 1}
    );
    public static final List<Object[]> EQUIPMENT_DATA_AS_OBJECT_ARRAY = Arrays.asList(
            new Object[]{1, "The holy keyboard", 325, 1},
            new Object[]{2, "The broken glasses", 10, 2},
            new Object[]{3, "The foldable ruler", 7, 3},
            new Object[]{4, "The leather cape", 7, 4},
            new Object[]{5, "The supersonic 50cm3", 2300, 5},
            new Object[]{6, "The abricotine cocktail molotov", 2300, 6},
            new Object[]{7, "The forgotten PET bottle", 1, 7},
            new Object[]{8, "The explosive rhum", 7, 8},
            new Object[]{9, "The explosif rhum", 7, 9},
            new Object[]{10, "The flammable harmonica", 7, 10},
            new Object[]{11, "The flutterable stick", 1, 11},
            new Object[]{12, "The plastic duck", 1, 12}

    );

    public static final List<PlayerDataType> PLAYER_DATA = Arrays.asList(
            new PlayerDataType(1, "Bertil the great", 99),
            new PlayerDataType(2, "Didier the reckless", 5),
            new PlayerDataType(3, "Daniel the chieftain", 7),
            new PlayerDataType(4, "Nadir the gangster", 7),
            new PlayerDataType(5, "Nohan the cheater", 250),
            new PlayerDataType(6, "Miguel the Valaisan", 8),
            new PlayerDataType(7, "James the spy", 4),
            new PlayerDataType(8, "Adri the smuggler", 6),
            new PlayerDataType(9, "Tony the artist", 9),
            new PlayerDataType(10, "Ludo the beekeeper", 4),
            new PlayerDataType(11, "Gaetan the forever rookie", 1),
            new PlayerDataType(12, "Yanis the comeback of the forever rookie", 1)
    );
}
