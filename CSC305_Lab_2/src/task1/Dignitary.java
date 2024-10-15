package task1;

import java.util.List;

class Dignitary {
    private final List<String> knownFor;
    private final List<Award> awards;

    private final String name;

    Dignitary(List<String> knownFor, List<Award> awards, String name) {
        this.knownFor = List.copyOf(knownFor);
        this.awards = List.copyOf(awards);
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        builder.append("\n\nKnown For:\n");
        for(String accolade : knownFor) {
            builder.append("\t").append(accolade).append("\n");
        }
        builder.append("\nAwards:\n");
        for(Award award : awards) {
            builder.append("\t").append(award).append("\n");
        }
        return builder.toString();
    }

    static class Award {
        private final String name;
        private final int year;

        Award(String name, int year) {
            this.name = name;
            this.year = year;
        }

        @Override
        public String toString() {
            return name + ", " + year;
        }
    }
}
