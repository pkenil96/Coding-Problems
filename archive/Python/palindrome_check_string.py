filename = 'words.txt'

def check_palindrome(word):
    word_len = len(word)
    left_index = 0
    right_index = word_len - 1
    for index in range(left_index, right_index):
        if word[left_index] != word[right_index]:
            return False
        else:
            left_index += 1
            right_index -= 1
    return True

if __name__ == '__main__':
    words = list()
    with open(filename) as f:
        for line in f:
            words.append(line)
    words = [line.rstrip('\n') for line in open(filename)]
    print(words)

    for word in words:
        response = check_palindrome(word)
        if response is True:
            print("{} is a palindrome.".format(word))
        else:
            print("{} is not a palindrome.".format(word))

