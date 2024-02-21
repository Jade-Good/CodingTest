#!/bin/bash

# Function to decode escaped characters
decode_escaped_chars() {
    local str="$1"
    # Use printf to decode escaped characters
    printf '%b' "$str"
}

# Function to print file names of added Java files in the last 20 commits to a text file
print_file_names() {
    # Output file name
    output_file="added_java_files.txt"
    
    # Clear the output file if it exists
    > "$output_file"
    
    # Iterate through the last 200 commits
    git log --format='%H' -n 200 |
    while read -r sha; do
        # Get added Java files in the commit
        added_files=$(git diff --name-only --diff-filter=A $sha~1 $sha)
        
        # Print commit message and added Java files to output file
        if [ -n "$added_files" ]; then
            echo "-------------------------------------------------- -------" >> "$output_file"
            echo "Files added in commit:" >> "$output_file"
            echo >> "$output_file"

            # Print file paths
            while IFS= read -r file; do
                # Convert escaped characters back into Korean
                decoded_file_name=$(decode_escaped_chars "$file")
                # Print the file name as is
                echo "[$(basename "$decoded_file_name")]($decoded_file_name)" >> "$output_file"
            done <<< "$added_files"

            echo >> "$output_file"
        fi
    done

    echo "Output saved to $output_file"
}

# Call the function to print file names
print_file_names
