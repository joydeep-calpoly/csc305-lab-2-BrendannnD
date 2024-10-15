package task2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

class Dignitary {
    private final List<String> knownFor;
    private final List<Award> awards;

    private final String name;


    @JsonCreator
    private Dignitary(@JsonProperty("knownFor") List<String> knownFor,@JsonProperty("awards") List<Award> awards, @JsonProperty("name")String name) {
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

        @JsonCreator
        private Award(@JsonProperty("name") String name, @JsonProperty("year") int year) {
            this.name = name;
            this.year = year;
        }

        @Override
        public String toString() {
            return name + ", " + year;
        }
    }
}
