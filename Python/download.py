from transformers import GPT2Tokenizer, GPT2LMHeadModel

# Replace 'gpt2' with the desired model name for GPT-2
model_name = "gpt2"

# Download model and tokenizer
tokenizer = GPT2Tokenizer.from_pretrained(model_name)
model = GPT2LMHeadModel.from_pretrained(model_name)

# Save model and tokenizer locally
model.save_pretrained("C:\\Python\\gpt2")
tokenizer.save_pretrained("C:\\Python\\gpt2")
