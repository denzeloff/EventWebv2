package eventweb.model;

public enum EventCategory {
    SYSTEM_ADMINISTRATION("System Administration"),
    SOFTWARE_DEVELOPMENT("Software Development"),
    PROJECT_MANAGEMENT("Project Management"),
    CLOUD_COMPUTING("Cloud Computing"),
    ARTIFICIAL_INTELLIGENCE("Artificial Intelligence"),
    NETWORK_SECURITY("Network Security");

    private String category;

    EventCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public static EventCategory fromString(String text) {
        for (EventCategory eventCategory : EventCategory.values()) {
            if (eventCategory.category.equalsIgnoreCase(text))
                return eventCategory;
        }
        return null;
    }

}
