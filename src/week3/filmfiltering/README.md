# Film Filtering Application

This Java console application manages a list of films and provides functionalities to sort and filter them based on different criteria.

## Film Class

The `Film` class represents a movie with the following properties:

- **filmName**: The title of the film (String).
- **filmType**: An array of genres/categories the film belongs to (String[]).
- **filmYear**: The release year of the film (int).
- **imdb**: The IMDb rating of the film (double).

The class provides getter methods for each property to access their values.


## Features

- Sort films by IMDb rating (descending order).
- Sort films by release year (ascending order).
- Filter and display films by genre.

## How It Works

1. A predefined list of films is created, each with:
    - Name
    - Array of genres
    - Release year
    - IMDb rating

2. Films are sorted and displayed based on IMDb rating and year.

3. Films can be filtered by a specified genre, printing matching films along with their other genres.

## Example Usage

The program sorts films by IMDb rating, then by release year, and finally filters films by the genre `"Dram"`.

## Technologies Used
1. Java Collections (ArrayList)

2. Sorting with Comparator

3. Basic console input/output