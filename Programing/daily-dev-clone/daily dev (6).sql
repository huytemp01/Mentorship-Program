CREATE TABLE [Category] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [category_name] nvarchar(MAX)
)
GO

CREATE TABLE [Tag] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [tag_name] nvarchar(MAX),
  [category_id] int
)
GO

CREATE TABLE [Users] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [email] nvarchar(MAX),
  [password] nvarchar(MAX),
  [user_name] nvarchar(MAX)
)
GO

CREATE TABLE [User_Follow_Tag] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [user_id] int,
  [tag_id] int
)
GO

CREATE TABLE [Post] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [thumbnail] nvarchar(MAX),
  [title] nvarchar(MAX),
  [content] nvarchar(MAX),
  [images] nvarchar(MAX),
  [link] nvarchar(MAX),
  [count_upvote] int,
  [count_downvote] int,
  [author_id] int,
  [post_type] int,
  [rss_link_id] int
)
GO

CREATE TABLE [PostType] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [type_name] nvarchar(MAX)
)
GO

CREATE TABLE [Post_Tag] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [tag_id] int,
  [post_id] int
)
GO

CREATE TABLE [User_Follow_Author] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [follower_id] int,
  [author_id] int
)
GO

CREATE TABLE [User_Vote_Post] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [user_id] int,
  [post_id] int,
  [voteType] int
)
GO

CREATE TABLE [VoteType] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [vote_value] nvarchar(MAX)
)
GO

CREATE TABLE [User_Comment_Post] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [user_id] int,
  [post_id] int,
  [comment_id] int
)
GO

CREATE TABLE [Comment] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [link] nvarchar(MAX),
  [image] nvarchar(MAX),
  [content] nvarchar(MAX),
  [comment_reply_id] int
)
GO

CREATE TABLE [User_Vote_Comment] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [user_id] int,
  [comment_id] int,
  [voteType] int
)
GO

CREATE TABLE [Source] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [domain_name] nvarchar(MAX)
)
GO

CREATE TABLE [RssLink] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [rss_link] nvarchar(MAX),
  [category_id] int,
  [source_id] int
)
GO

CREATE TABLE [User_RssLink] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [rsslink_id] int,
  [user_id] int
)
GO

CREATE TABLE [User_Follow_Source] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [user_id] int,
  [source_id] int
)
GO

ALTER TABLE [Tag] ADD FOREIGN KEY ([category_id]) REFERENCES [Category] ([id])
GO

ALTER TABLE [User_Follow_Tag] ADD FOREIGN KEY ([user_id]) REFERENCES [Users] ([id])
GO

ALTER TABLE [User_Follow_Tag] ADD FOREIGN KEY ([tag_id]) REFERENCES [Tag] ([id])
GO

ALTER TABLE [Post] ADD FOREIGN KEY ([author_id]) REFERENCES [Users] ([id])
GO

ALTER TABLE [Post] ADD FOREIGN KEY ([post_type]) REFERENCES [PostType] ([id])
GO

ALTER TABLE [Post] ADD FOREIGN KEY ([rss_link_id]) REFERENCES [RssLink] ([id])
GO

ALTER TABLE [Post_Tag] ADD FOREIGN KEY ([tag_id]) REFERENCES [Tag] ([id])
GO

ALTER TABLE [Post_Tag] ADD FOREIGN KEY ([post_id]) REFERENCES [Post] ([id])
GO

ALTER TABLE [User_Follow_Author] ADD FOREIGN KEY ([follower_id]) REFERENCES [Users] ([id])
GO

ALTER TABLE [User_Follow_Author] ADD FOREIGN KEY ([author_id]) REFERENCES [Users] ([id])
GO

ALTER TABLE [User_Vote_Post] ADD FOREIGN KEY ([user_id]) REFERENCES [Users] ([id])
GO

ALTER TABLE [User_Vote_Post] ADD FOREIGN KEY ([post_id]) REFERENCES [Post] ([id])
GO

ALTER TABLE [User_Vote_Post] ADD FOREIGN KEY ([voteType]) REFERENCES [VoteType] ([id])
GO

ALTER TABLE [User_Comment_Post] ADD FOREIGN KEY ([user_id]) REFERENCES [Users] ([id])
GO

ALTER TABLE [User_Comment_Post] ADD FOREIGN KEY ([post_id]) REFERENCES [Post] ([id])
GO

ALTER TABLE [User_Comment_Post] ADD FOREIGN KEY ([comment_id]) REFERENCES [Comment] ([id])
GO

ALTER TABLE [Comment] ADD FOREIGN KEY ([id]) REFERENCES [Comment] ([comment_reply_id])
GO

ALTER TABLE [User_Vote_Comment] ADD FOREIGN KEY ([user_id]) REFERENCES [Users] ([id])
GO

ALTER TABLE [User_Vote_Comment] ADD FOREIGN KEY ([comment_id]) REFERENCES [Comment] ([id])
GO

ALTER TABLE [User_Vote_Comment] ADD FOREIGN KEY ([voteType]) REFERENCES [VoteType] ([id])
GO

ALTER TABLE [RssLink] ADD FOREIGN KEY ([category_id]) REFERENCES [Category] ([id])
GO

ALTER TABLE [RssLink] ADD FOREIGN KEY ([source_id]) REFERENCES [Source] ([id])
GO

ALTER TABLE [User_RssLink] ADD FOREIGN KEY ([rsslink_id]) REFERENCES [RssLink] ([id])
GO

ALTER TABLE [User_RssLink] ADD FOREIGN KEY ([user_id]) REFERENCES [Users] ([id])
GO

ALTER TABLE [User_Follow_Source] ADD FOREIGN KEY ([user_id]) REFERENCES [Users] ([id])
GO

ALTER TABLE [User_Follow_Source] ADD FOREIGN KEY ([source_id]) REFERENCES [Source] ([id])
GO
