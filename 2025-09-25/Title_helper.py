class TitleHelper:
    @staticmethod
    def manipulate_string(input_str: str) -> str:
        words = input_str.strip().split()
        result = []
        for i, word in enumerate(words):
            formatted_word = word[0].upper() + word[1:] if word else ""
            result.append(formatted_word)
        return "_".join(result)


if __name__ == "__main__":
    input_str = input()
    result = TitleHelper.manipulate_string(input_str)
    print(result)
