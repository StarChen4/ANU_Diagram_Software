package com.pp1.digramsoft;

enum EntityType {
    STAKEHOLDER_MAP("sm", "StakeholderMap"),
    RAINBOW_CHART("rc", "RainbowChart"),
    STAKEHOLDER("s", "Stakeholder");
    private String symbol;
    private String typeName;
    EntityType(String symbol, String typeName) {
        this.symbol = symbol;
        this.typeName = typeName;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return typeName;
    }
}