import csv
from matplotlib import pyplot as plt
from datetime import datetime

# Function to convert ISO 8601 date format to week number
def iso8601_to_week(iso_date):
    dt = datetime.fromisoformat(iso_date.replace("Z", "+00:00"))
    return dt.strftime('%G-W%V')

# I apologize, this doesn't really work
# Function to generate scatter plot
def generateScatterPlot(authorsFile, filesFile):
    authorsData = []
    
    # Read data from the file
    with open(authorsFile, 'r') as file:
        reader = csv.reader(file)
        header = next(reader)
        # Append the stuff
        for row in reader:
            authorsData.append(row)

    # Read from the CSV files
    filesData = {}
    with open(files_file, 'r') as file:
        reader = csv.reader(file)
        header = next(reader)
        for row in reader:
            filesData[row[0]] = int(row[1])

    # Extract the authors!!! Do the colors!!!
    authorsSet = set([row[1] for row in authorsData])
    colorMap = {author: plt.cm.tab10(i) for i, author in enumerate(authorsSet)}

    # Make a graph?
    for author in authorsSet:
        x_values = []  
        y_values = []  
        c_values = []  

        for row in authorsData:
            if row[1] == author:
                filename = row[0]
                if filename in filesData:
                    touches = files_data[filename]
                    date = row[2]
                    week = iso8601_to_week(date)
                    x_values.append(week)
                    y_values.append(touches)
                    c_values.append(color_map[author])  # The color part threw me off... I'm sorry...
        # Do the scatter
        plt.scatter(x_values, y_values, label=author, c=c_values, alpha=0.7)

    # Configure the plot
    plt.grid(True)
    plt.show()

# The random input files
authorsFileInput = 'data/authors_rootbeer.csv'
filesFileInput = 'data/file_rootbeer.csv'
# Make the plot!
generateScatterPlot(authorsFileInput, filesFileInput)
