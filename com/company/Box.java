package com.company;

public class Box {

    private int[] dimensions;
    private int smallestWallArea = Integer.MAX_VALUE;

    public Box(final String unparsedDimensions) {
        String[] dimensionsArray = unparsedDimensions.split("x");
        try {
            parse(dimensionsArray);
        } catch (Exception e) {
            System.out.println("Parse data error: " + e.getMessage());
        }
    }

    private void parse(String[] dimensionsArray) throws IllegalArgumentException {
        if (dimensionsArray.length != 3) {
            throw new IllegalArgumentException("Input data error");
        }
        dimensions = new int[3];
        for (int i = 0; i < 3; i++) {
            dimensions[i] = Integer.parseInt(dimensionsArray[i]);
        }
    }

    private int multiplyDimensions(final int firstDimension, final int secondDimension) {
        final int result = dimensions[firstDimension] * dimensions[secondDimension];
        smallestWallArea = Math.min(result, smallestWallArea);
        return result;
    }

    public int getRequiredPaper() {
        int surfaceArea = (2 * multiplyDimensions(0, 1)) + (2 * multiplyDimensions(1, 2)) + (2 * multiplyDimensions(0, 2));
        return surfaceArea + smallestWallArea;
    }
}