# code-review-gpt


prompt - 

  promptArray.push(`The change has the following title: ${title}.

    Your task is:
    - Review the code changes and provide feedback.
    - If there are any bugs, highlight them.
    - Provide details on missed use of best-practices.
    - Does the code do what it says in the commit messages?
    - Do not highlight minor issues and nitpicks.
    - Use bullet points if you have multiple comments.
    - Provide security recommendations if there are any.

    You are provided with the code changes (diffs) in a unidiff format.
    Do not provide feedback yet. I will follow-up with a description of the change in a new message.`
  );

  promptArray.push(`A description was given to help you assist in understand why these changes were made.
    The description was provided in a markdown format. Do not provide feedback yet. I will follow-up with the code changes in diff format in a new message.
