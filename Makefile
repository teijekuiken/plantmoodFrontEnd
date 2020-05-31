all:
	chmod +x .githooks/pre-commit
git:
	git config core.hooksPath .githooks
