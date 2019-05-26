package domain;

public class Category {

    private int categoryId;
    private String name;

    public Category(){}

    public Category(int categoryId, String nume) {
        this.categoryId = categoryId;
        this.name = nume;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String nume) {
        this.name = nume;
    }


    @Override
    public String toString() {
        return "Category Id=" + categoryId +
                "   Name='" + name + "\n";
    }
}
