CREATE TABLE [Category] (
  [id] int PRIMARY KEY,
  [subject_name] nvarchar
)
GO

CREATE TABLE [Tag] (
  [id] int PRIMARY KEY,
  [tag_name] nvarchar,
  [Subject_id] int
)
GO

CREATE TABLE [User] (
  [id] int PRIMARY KEY,
  [email] nvarchar,
  [password] nvarchar,
  [user_name] nvarchar
)
GO

CREATE TABLE [User_Follow_Tag] (
  [id] int PRIMARY KEY,
  [user_id] int,
  [tag_id] int
)
GO

CREATE TABLE [Post] (
  [id] int PRIMARY KEY,
  [thumbnail] nvarchar,
  [title] nvarchar,
  [content] nvarchar,
  [images] nvarchar,
  [link] nvarchar,
  [count_upvote] int,
  [count_downvote] int,
  [author_id] int,
  [post_type] int
)
GO

CREATE TABLE [PostType] (
  [id] int PRIMARY KEY,
  [type_name] nvarchar
)
GO

CREATE TABLE [Post_Tag] (
  [id] int PRIMARY KEY,
  [tag_id] int,
  [post_id] int
)
GO

CREATE TABLE [User_Follow_Author] (
  [id] int PRIMARY KEY,
  [follower_id] int,
  [author_id] int
)
GO

CREATE TABLE [User_Vote_Post] (
  [id] int PRIMARY KEY,
  [user_id] int,
  [post_id] int,
  [voteType] int
)
GO

CREATE TABLE [VoteType] (
  [id] int PRIMARY KEY,
  [vote_value] nvarchar
)
GO

CREATE TABLE [User_Comment_Post] (
  [id] int PRIMARY KEY,
  [user_id] int,
  [post_id] int,
  [comment_id] int
)
GO

CREATE TABLE [Comment] (
  [id] int PRIMARY KEY,
  [link] nvarchar,
  [image] nvarchar,
  [content] nvarchar,
  [comment_reply_id] int
)
GO

CREATE TABLE [User_Vote_Comment] (
  [id] int PRIMARY KEY,
  [user_id] int,
  [comment_id] int,
  [voteType] int
)
GO

CREATE TABLE [Source] (
  [id] int PRIMARY KEY,
  [domain_name] nvarchar
)
GO

CREATE TABLE [RssLink] (
  [id] int PRIMARY KEY,
  [rss_link] nvarchar,
  [source_id] int
)
GO

CREATE TABLE [RssLink_Category] (
  [id] int,
  [rsslink_id] int,
  [category_id] int
)
GO

CREATE TABLE [User_RssLink] (
  [id] int,
  [rsslink_id] int,
  [user_id] int
)
GO

ALTER TABLE [Tag] ADD FOREIGN KEY ([Subject_id]) REFERENCES [Category] ([id])
GO

ALTER TABLE [User_Follow_Tag] ADD FOREIGN KEY ([user_id]) REFERENCES [User] ([id])
GO

ALTER TABLE [User_Follow_Tag] ADD FOREIGN KEY ([tag_id]) REFERENCES [Tag] ([id])
GO

ALTER TABLE [Post] ADD FOREIGN KEY ([author_id]) REFERENCES [User] ([id])
GO

ALTER TABLE [Post] ADD FOREIGN KEY ([post_type]) REFERENCES [PostType] ([id])
GO

ALTER TABLE [Post_Tag] ADD FOREIGN KEY ([tag_id]) REFERENCES [Tag] ([id])
GO

ALTER TABLE [Post_Tag] ADD FOREIGN KEY ([post_id]) REFERENCES [Post] ([id])
GO

ALTER TABLE [User_Follow_Author] ADD FOREIGN KEY ([follower_id]) REFERENCES [User] ([id])
GO

ALTER TABLE [User_Follow_Author] ADD FOREIGN KEY ([author_id]) REFERENCES [User] ([id])
GO

ALTER TABLE [User_Vote_Post] ADD FOREIGN KEY ([user_id]) REFERENCES [User] ([id])
GO

ALTER TABLE [User_Vote_Post] ADD FOREIGN KEY ([post_id]) REFERENCES [Post] ([id])
GO

ALTER TABLE [User_Vote_Post] ADD FOREIGN KEY ([voteType]) REFERENCES [VoteType] ([id])
GO

ALTER TABLE [User_Comment_Post] ADD FOREIGN KEY ([user_id]) REFERENCES [User] ([id])
GO

ALTER TABLE [User_Comment_Post] ADD FOREIGN KEY ([post_id]) REFERENCES [Post] ([id])
GO

ALTER TABLE [User_Comment_Post] ADD FOREIGN KEY ([comment_id]) REFERENCES [Comment] ([id])
GO

ALTER TABLE [Comment] ADD FOREIGN KEY ([id]) REFERENCES [Comment] ([comment_reply_id])
GO

ALTER TABLE [User_Vote_Comment] ADD FOREIGN KEY ([user_id]) REFERENCES [User] ([id])
GO

ALTER TABLE [User_Vote_Comment] ADD FOREIGN KEY ([comment_id]) REFERENCES [Comment] ([id])
GO

ALTER TABLE [User_Vote_Comment] ADD FOREIGN KEY ([voteType]) REFERENCES [VoteType] ([id])
GO

ALTER TABLE [RssLink] ADD FOREIGN KEY ([source_id]) REFERENCES [Source] ([id])
GO

ALTER TABLE [RssLink_Category] ADD FOREIGN KEY ([rsslink_id]) REFERENCES [RssLink] ([id])
GO

ALTER TABLE [RssLink_Category] ADD FOREIGN KEY ([category_id]) REFERENCES [Category] ([id])
GO

ALTER TABLE [User_RssLink] ADD FOREIGN KEY ([rsslink_id]) REFERENCES [RssLink] ([id])
GO

ALTER TABLE [User_RssLink] ADD FOREIGN KEY ([user_id]) REFERENCES [User] ([id])
GO
