import heapq

# sorting the list of students based on the marks
# if two students have same marks, the student who
# is elder gets the priority and if both marks and
# age are same, the student whose name appears first
# in alphabetical order gets priority

class Student:
    def __init__(self, name, marks, age):
        self.name = name
        self.marks = marks
        self.age = age

    def __lt__(self, other):
        if self.marks > other.marks:
            return True
        if self.marks == other.marks:
            if self.age < other.age:
                return True
            return self.name < other.name
        return False

    def __str__(self):
        string = 'Name: {}\tMarks: {}\tAge:{}'.format(self.name, self.marks, self.age)
        return string


def printStudents(students):
    for student in students:
        print(student)
    print()
students = [
    Student("Kenil", 48, 25),
    Student("Kelsi", 97, 25),
    Student("Johnn", 87, 30),
    Student("Happy", 87, 30),
    Student("Julie", 77, 20),
    Student("Puppy", 48, 30)
    ]
printStudents(students)
students.sort()
printStudents(students)
