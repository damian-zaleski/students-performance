package pl.degath.sorter;

import com.fasterxml.jackson.annotation.JsonClassDescription;

@JsonClassDescription
public record Student(String name, Double performance) {
}
