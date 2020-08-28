package org.sg.flooring.enums;

import java.util.stream.Stream;

public enum WoodType {
    BEECH("hard, strong and heavy wood. It has a fine, tight grain and even texture. Beech wood is " +
            "very light in colour and has a high shock resistance.", 3.50, 4.15),
    OAK("a very popular wood, it is very hard wearing and heavy. It is known for having lovely open wood grain markings. Oak can be purchased in two shades; white oak, which is grey/brown in colour or red " +
            "oak which is very similar but with a prominent reddish tint", 4.50, 4.15),
    ASH("a tough hardwood which is known for its excellent bending abilities. It is primarily used for bent pieces of furniture such as a chair with curved backrests. " +
            "Ash is light brown in colour with a straight grain.", 4.50, 3.15),
    MAHOGANY("an expensive hardwood and varies in colour from a medium brown to a deep red brown, depending on its age. It is a very traditional, versatile and popular" +
            " type of wood. It is also a popular choice for use on veneers.", 8.50, 5.15),
    WALNUT(" a hardwood and is known for its strength, straight grain and its rich " +
            "chocolate brown colour, however lighter shades are available.", 4.25, 4.15),
    MAPLE("much more durable and heavier. As maple wood is so strong and moisture resistant it is the ideal wood to withstand years of wear and tear. Maple wood is pale in colour and has natural swirls and twists in " +
            "the wood grain. It can easily accepts any type of stain or paint.", 4.25, 3.75),
    PINE("very affordable and lightweight with a pale finish which is great for staining. It is less durable wood compared to hard woods such as maple or oak. Pine blends well with other woods, making it ideal if you are looking " +
            "for furniture that will match existing pieces in your home.", 3.25, 4.15);

    private String description;
    private double costPerSqFt;
    private double laborCostPerSqFt;

    WoodType(String description, double costPerSqFt, double laborCostPerSqFt) {
        this.description = description;
        this.costPerSqFt = costPerSqFt;
        this.laborCostPerSqFt = laborCostPerSqFt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCostPerSqFt() {
        return costPerSqFt;
    }

    public void setCostPerSqFt(double costPerSqFt) {
        this.costPerSqFt = costPerSqFt;
    }

    public double getLaborCostPerSqFt() {
        return laborCostPerSqFt;
    }

    public void setLaborCostPerSqFt(double laborCostPerSqFt) {
        this.laborCostPerSqFt = laborCostPerSqFt;
    }

    public static Stream<WoodType> stream() {
        return Stream.of(WoodType.values());
    }
}
