import sys

def afd(expression):
    state = 0
    index = 0
    length = len(expression)
    
    def get_char():
        nonlocal index
        if index < length:
            return expression[index]
        return None
    
    def is_digit(char):
        return char is not None and '0' <= char <= '9'
    
    while index < length:
        char = get_char()
        
        if state == 0:
            if char == '+':
                state = 1
            elif is_digit(char):
                state = 2
            else:
                return 'INVALIDO'
        elif state == 1:
            if char == '+':
                state = 3
            else:
                return 'SUMA'
        elif state == 2:
            if is_digit(char):
                state = 2
            elif char == '.':
                state = 4
            else:
                return 'ENTERO'
        elif state == 3:
            return 'SUMA_DOBLE'
        elif state == 4:
            if is_digit(char):
                state = 5
            else:
                return 'INVALIDO'
        elif state == 5:
            if is_digit(char):
                state = 5
            else:
                return 'DECIMAL'
        
        index += 1
    
    if state == 1:
        return 'SUMA'
    elif state == 2:
        return 'ENTERO'
    elif state == 3:
        return 'SUMA_DOBLE'
    elif state == 5:
        return 'DECIMAL'
    else:
        return 'INVALIDO'

if __name__ == "__main__":
    if len(sys.argv) > 1:
        expression = sys.argv[1]
        print(afd(expression))
    else:
        print("Usage: python AFD.py <expression>")
