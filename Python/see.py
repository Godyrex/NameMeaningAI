from transformers import GPT2Tokenizer, GPT2LMHeadModel
import re
import argparse

parser = argparse.ArgumentParser(description='Generate a sentence based on a prompt.')

parser.add_argument('--temperature', type=float, default=0.8, help='Temperature for text generation')
parser.add_argument('--top_k', type=int, default=50, help='Top_k for text generation')

# Parse the command-line arguments
args = parser.parse_args()
def generate_sentence(prompt):
    local_model_path = "C:\\Python\\gpt2"
    tokenizer = GPT2Tokenizer.from_pretrained(local_model_path)
    model = GPT2LMHeadModel.from_pretrained(local_model_path)

    inputs = tokenizer(prompt, return_tensors="pt", max_length=100, truncation=True)
    outputs = model.generate(
        **inputs,
        max_length=50,
        num_return_sequences=1,
        do_sample=True,
        temperature=args.temperature,
        top_k=args.top_k,
        top_p=0.95
    )
    generated_text = tokenizer.decode(outputs[0], skip_special_tokens=True)

    # Post-process the generated sentence
    filtered_sentences = post_process_generated_text(generated_text)

    return filtered_sentences

def post_process_generated_text(generated_text):
    # Split into sentences
    sentences = re.split(r'(?<!\w\.\w.)(?<![A-Z][a-z]\.)(?<=\.|\?)\s', generated_text)
    
    # Remove duplicates
    unique_sentences = list(set(sentences))
    
    # Filter out short or nonsensical sentences
    filtered_sentences = [s for s in unique_sentences if len(s.split()) > 3]
    
    return filtered_sentences

# Read the prompt from standard input
name = input()
prompt = f"The meaning of the name {name} is"
# Generate the sentence
generated_sentences = generate_sentence(prompt)

# Print the filtered sentences to standard output
for sentence in generated_sentences:
    print(sentence)
